package Controller;

import Models.TreatmentModel;
import Services.Communication.OutgoingCommunication;
import Services.Constants;
import Services.SettingsDialog;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.prefs.Preferences;

public class DisplayController {

    @FXML
    private ImageView imageViewLogo;
    @FXML
    private Label lblTime, lblNextTreatment;
    private static Label s_lblNextTreatment;

    @FXML
    private ListView listPharm , listNurse;
    private static ListView s_listPharm , s_listNurse;

    private Image imageLogo;
    Calendar calendar;
    String currentTime;
    Preferences settingsPrefs;

    public void initialize(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            currentTime = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());
            lblTime.setText(currentTime);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        imageLogo = new Image(getClass().getResource("/logo.png").toString());
        imageViewLogo.setImage(imageLogo);
        calendar = Calendar.getInstance(TimeZone.getDefault());
        settingsPrefs = Preferences.userNodeForPackage(SettingsDialog.class);

        s_lblNextTreatment = lblNextTreatment;
        s_listPharm = listPharm;
        s_listNurse = listNurse;
    }

    public void ShowSettings(){
        SettingsDialog.ShowSettingsDialog();
    }

    public void Start()
    {
        //send request to server
        new OutgoingCommunication(settingsPrefs.get(Constants.SERVER_IP,String.class.toString()),
                Integer.parseInt(settingsPrefs.get(Constants.SERVER_PORT,String.class.toString())),
                Constants.NEWDISPLAYER).start();
    }

    public static void updateNextTreatmentlbl(int patientNum , int NumberServiceProvider ,String serviceType )
    {
        String mes = "";
        if(serviceType.equals(Constants.PHARMROLE))
            mes = "תור מספר "+patientNum + "לדלפק "+NumberServiceProvider;
        else if(serviceType.equals(Constants.NURSEROLE))
            mes = "תור מספר "+ patientNum + "לחדר " + NumberServiceProvider;

        s_lblNextTreatment.setText(mes);
    }

    public static void updateQueues(ArrayList<TreatmentModel> pharemlist ,ArrayList<TreatmentModel> nuresList )
    {
        if(pharemlist.size()>0){
            s_listPharm.getItems().clear();
            pharemlist.forEach((item) -> s_listPharm.getItems().add(item.getNumberPatient()+"נמצא מטופל "+item.getNumberServiceProvider()+"בדלפק "));

        }
        if(nuresList.size()>0){
            s_listNurse.getItems().clear();
            nuresList.forEach((item) -> s_listNurse.getItems().add(item.getNumberPatient()+"נמצא מטופל "+item.getNumberServiceProvider()+"בחדר אחות "));

        }
    }
}
