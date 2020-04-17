package sample;

import animatefx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import sample.utils.JarvisAnimation;
import sample.utils.JarvisSound;

import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class Controller implements Initializable {
    // FXML element
    @FXML
    public BorderPane rootPane;
    @FXML
    public ImageView projectsBtn;
    @FXML
    public ImageView protocolsBtn;
    @FXML
    public AnchorPane jarvis;
    @FXML
    public AnchorPane miniJarvis;
    @FXML
    public ImageView starkIndustry;


    // Create at Runtime Objects
    public WebView cnn = new WebView();
    public BorderPane projectsUI = new BorderPane();
    public AnchorPane showCase = new AnchorPane();

    // Utils
    private JarvisAnimation jarvisAnimation = new JarvisAnimation(this);
    private JarvisSound jarvisSound = new JarvisSound();

    //Variables
    public boolean isJarvis = true;

    @FXML
    private void handleClick(MouseEvent e) throws IOException {
          jarvisSound.buttonClick();
//        Node source = (Node) e.getSource();
//        Window primaryStage = source.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
//        primaryStage.getScene().setRoot(root);
//        new SlideInRight(root).setSpeed(5).play();


        if(e.getSource() == jarvis || e.getSource() == miniJarvis  ) {
            jarvisAnimation.minAndMaxJarvis();
        }else if(e.getSource() == projectsBtn) {
            if (isJarvis == true)
            {
                jarvisAnimation.minAndMaxJarvis();
            }
            if(rootPane.getCenter() != projectsUI) {
                projectsUI.setOpacity(1);
                rootPane.setCenter(projectsUI);

                projectsUI.setCenter(showCase);
                new SlideInUp(showCase).setSpeed(3).play();
                new Pulse(showCase).setSpeed(1).play();
                jarvisSound.boot1();

            }
        }else if(e.getSource() == protocolsBtn){
            if(rootPane.getCenter() != cnn) {
                cnn.setOpacity(1);
                rootPane.setCenter(cnn);
                new SlideInLeft(cnn).setSpeed(1).play();
                jarvisSound.aINoise();
            }
        }
    }





    // Start up
    // Set up
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // F.R.I.D.A.Y Set Up
        cnn.setOpacity(0);
        WebEngine engine;
        engine = cnn.getEngine();
        engine.load(new File("src/images/Test.html").toURI().toString());
        rootPane.setCenter(cnn);


        jarvisAnimation.BootUp();





        // Project UI
        Image mark44 = new Image(new File("src/images/mark-42.png").toURI().toString());
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        showCase.setBackground(new Background(new BackgroundImage(mark44,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));






    }
}
