package Services.Communication;


import Services.Constants;
import javafx.application.Platform;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class OutgoingCommunication extends Thread{

    String serverIP = "";
    String message;
    int serverPort;

    public OutgoingCommunication(String serverIP, int serverPort, String message){
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.message = message;
    }

    @Override
    public void run() {
        Socket client = null;
        PrintWriter pwOut =  null;
        BufferedReader brIn = null;
        String incomingCommand;
        try {
            // now open a conversation with the server
            InetAddress neighborAddress = InetAddress.getByName(serverIP);
            // build a socket and it connects automatically
            client = new Socket(neighborAddress, serverPort);
            // send the message
            pwOut = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            InputStream inputStream = client.getInputStream();
            pwOut.write(message + "\n");
            pwOut.flush();


            /*get response from server*/
            /*[servic type][patient number]*/
            // create a DataInputStream so we can read data from it.

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // read the list of messages from the socket
            while (!this.isInterrupted()){
                List<String> listOfMessages = (List<String>) objectInputStream.readObject();


            }

        } catch (IOException e){
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if(client != null) {
                client.close();
                pwOut.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
