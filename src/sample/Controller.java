package sample;

import animatefx.animation.*;
import com.sun.javafx.webkit.WebConsoleListener;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    public GridPane topMenu;

    @FXML
    public ImageView projectsBtn;
    @FXML
    public ImageView protocolsBtn;
    @FXML
    public ImageView systemBtn;


    @FXML
    public GridPane sideMenu;
    // project btn
    // AI's / Tech
    @FXML
    public ImageView fridayBtn;
    @FXML
    public ImageView edithBtn;
    @FXML
    public ImageView arkBtn;

    //suits
    @FXML
    public ImageView mark6Btn;
    @FXML
    public ImageView mark2Btn;
    @FXML
    public ImageView markXLBtn;
    @FXML
    public ImageView warBtn;
    @FXML
    public ImageView legionBtn;


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
    private JarvisSound jarvisSound = JarvisSound.getInstance();

    //Variables
    public boolean isJarvis = true;
    public boolean isTopMenu = false;

    @FXML
    private void handleClick(MouseEvent e) throws IOException {
        jarvisSound.buttonClick();
//        Node source = (Node) e.getSource();
//        Window primaryStage = source.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
//        primaryStage.getScene().setRoot(root);
//        new SlideInRight(root).setSpeed(5).play();


        if (e.getSource() == jarvis || e.getSource() == miniJarvis) {
            jarvisSound.stop();
            jarvisAnimation.minAndMaxJarvis();
        } else if (e.getSource() == projectsBtn) {
            if(mark2Btn.getOpacity() == 0 && fridayBtn.getOpacity() == 0) {
                jarvisSound.stop();
                jarvisAnimation.loadSlideMenu(0, 100,2.5);
                jarvisAnimation.unloadMainMenu(0,400,2.5);
            }
        } else if (e.getSource() == protocolsBtn) {
            if(mark2Btn.getOpacity() != 0 && fridayBtn.getOpacity() != 0) {
                jarvisSound.stop();
                jarvisAnimation.unloadSlideMenu(0, 100,2.5);
            }
           // code to be added
        } else if (e.getSource() == systemBtn) {
            if(mark2Btn.getOpacity() != 0 && fridayBtn.getOpacity() != 0) {
                jarvisSound.stop();
                jarvisAnimation.unloadSlideMenu(0, 100,2.5);
            }
            // code to be added
        }else if(e.getSource() == fridayBtn){
            if (rootPane.getCenter() != cnn) {
                jarvisSound.stop();
                cnn.setOpacity(1);
                new FadeIn(cnn).setSpeed(1).play();
                jarvisSound.aINoise();
                jarvisAnimation.minAndMaxJarvis(cnn);
            }
        }else if(e.getSource() == mark2Btn){
            if (rootPane.getCenter() != projectsUI) {
                projectsUI.setOpacity(1);
                jarvisSound.stop();
                projectsUI.setCenter(showCase);
                new SlideInUp(showCase).setSpeed(3).play();
                new Pulse(showCase).setSpeed(1).play();
                jarvisSound.boot1();
                jarvisAnimation.minAndMaxJarvis(projectsUI);

            }
        }

    }

    public void buttonEnter(MouseEvent e) {

        Glow glow = new Glow();
        glow.setLevel(1);
        if (e.getSource() == projectsBtn) {
            projectsBtn.setEffect(glow);
        } else if (e.getSource() == protocolsBtn) {
            protocolsBtn.setEffect(glow);
        }else if (e.getSource() == systemBtn) {
            systemBtn.setEffect(glow);
        }else{
            for(Node node : sideMenu.getChildren()){
                if(e.getSource() == node){
                    node.setEffect(glow);
                }
            }
        }
    }

    public void buttonExit(MouseEvent e) {
        Glow glow = new Glow();
        glow.setLevel(0.2);
        if (e.getSource() == projectsBtn) {
            projectsBtn.setEffect(glow);
        } else if (e.getSource() == protocolsBtn) {
            protocolsBtn.setEffect(glow);
        }else if (e.getSource() == systemBtn) {
            systemBtn.setEffect(glow);
        }else{
            for(Node node : sideMenu.getChildren()){
                if(e.getSource() == node){
                    node.setEffect(glow);
                }
            }
        }
    }


    // Start up
    // Set up
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //before System Boot-up
        // F.R.I.D.A.Y Set Up
        cnn.setOpacity(0);
        cnn.autosize();
        WebEngine engine;
        engine = cnn.getEngine();
        //engine.load("http://www.mohammedzaman.co.uk/jarvis-models/examples/war-machine.html"); // not working
        engine.load(new File("src/media/images/html/friday.html").toURI().toString());
        rootPane.setCenter(cnn);


        jarvisAnimation.BootUp();


        // Project UI
        Image mark44 = new Image(new File("src/media/images/Projects/mark-42.png").toURI().toString());
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        showCase.setBackground(new Background(new BackgroundImage(mark44,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));


    }


    public void menuEnter(MouseEvent e) {
        if(e.getSource() == topMenu){
            if(projectsBtn.getOpacity() != 1) {
                jarvisAnimation.loadMainMenu(0, 400, 1.5);
            }
        }

    }

    public void menuExit(MouseEvent e) {
//        if(e.getSource() == topMenu){
//            if(topMenu.getOpacity() != 0) {
//                jarvisAnimation.unloadMainMenu(0, 100, true);
//            }
//        }

    }
}
