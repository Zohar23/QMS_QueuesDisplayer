package Services.Communication;


import Controller.DisplayController;
import Models.ToDisplayerModel;
import Models.TreatmentModel;
import Services.Constants;
import javafx.application.Platform;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class OutgoingCommunication extends Thread{

    String serverIP = "";
    String message;
    int serverPort;

    ObjectOutputStream toServer;
    ObjectInputStream fromServer;

    public OutgoingCommunication(String serverIP, int serverPort, String message){
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.message = message;
    }

    @Override
    public void run() {
        Socket client = null;

        String incomingCommand;
        try {
            // now open a conversation with the server
            InetAddress neighborAddress = InetAddress.getByName(serverIP);
            // build a socket and it connects automatically
            client = new Socket(neighborAddress, serverPort);
            // Create an output stream to the server
            toServer = new ObjectOutputStream(client.getOutputStream());
            fromServer = new ObjectInputStream(client.getInputStream());
            toServer.writeUTF(this.message);
            toServer.flush();

            /*get response from server*/

            // read the list of messages from the socket
            while (!this.isInterrupted()){

                //From Server//
                //Check the header
                incomingCommand = fromServer.readUTF();
                ToDisplayerModel toDisplayer = (ToDisplayerModel) fromServer.readObject();
                TreatmentModel treatment = toDisplayer.getNextTreatment();

                if(incomingCommand.equals(Constants.UPDATEDISPLAYER))
                {
                    Platform.runLater(() -> DisplayController.updateNextTreatmentlbl(
                            treatment.getNumberPatient(),
                            treatment.getNumberServiceProvider(),
                            toDisplayer.getPharmOrNurse()
                            ));

                    //TODO: update lists
                    Platform.runLater(() ->DisplayController.updateQueues(
                            toDisplayer.getPharmList(),
                            toDisplayer.getNurseList()
                            ));
                }
                else if(incomingCommand.equals(Constants.NEWDISPLAYER))
                {
                    //TODO: update lists
                    Platform.runLater(() ->DisplayController.updateQueues(
                            toDisplayer.getPharmList(),
                            toDisplayer.getNurseList()
                    ));
                }
            }

        } catch (IOException e){

            String exceptionClassName = e.getClass().getName();
            if(exceptionClassName.equals(SocketException.class.getName()) || exceptionClassName.equals(EOFException.class.getName()) )
              System.out.println("Connection with the server is closed");
            else
                e.printStackTrace();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            if(client != null) {
                client.close();
                toServer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
