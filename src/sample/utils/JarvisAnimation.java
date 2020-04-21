package sample.utils;

import animatefx.animation.*;
import animatefx.util.SequentialAnimationFX;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Node;
import javafx.util.Duration;
import sample.Controller;


import java.util.*;

public class JarvisAnimation {

    Controller controller;
    JarvisSound jarvisSound;
    public JarvisAnimation (Controller controller){
        this.controller = controller;
        this.jarvisSound =  JarvisSound.getInstance();

    }

    public void BootUp(){
        jarvisSound.boot1();

        loadMainMenu(1000,400,1.5);

        controller.rootPane.setCenter(controller.jarvis);
        jarvisSound.boot3();
        controller.jarvis.setOpacity(0);
        FadeIn  jarvisAnim =   new FadeIn(controller.jarvis);
        jarvisAnim.setSpeed(1);
        jarvisAnim.setDelay(new Duration(5000));
        jarvisAnim.setOnFinished(e -> jarvisSound.welcome());
        jarvisAnim.play();



        controller.starkIndustry.setOpacity(1);
        jarvisSound.boot4();
        FadeIn stark = new FadeIn(controller.starkIndustry);
        stark.setSpeed(2);
        stark.setDelay(new Duration(1000));
        stark.play();

    }

    public void loadMainMenu(int start, int interval,double speed){
        int startPoint = start;
        int i = 0;
        for(Node node : controller.topMenu.getChildren().sorted()) {
            FadeInUp projects =  new FadeInUp(node);
            if(i != 0) {
                projects.setDelay(new Duration(startPoint));
            }
            projects.setSpeed(speed);
            if(i != controller.sideMenu.getChildren().size() - 1) {
                projects.setOnFinished(e -> jarvisSound.boot2());
            }
            projects.play();
            startPoint = startPoint + interval;
            i++;
        }


    }



    public void unloadMainMenu(int start, int interval,double speed){

        int startPoint = start;
        int i = 0;
        jarvisSound.boot2();

        ObservableList<Node> projectsBtn = FXCollections.observableArrayList(
                controller.topMenu.getChildren().sorted()
        );

        Collections.reverse(projectsBtn);


        for(Node node : projectsBtn) {
            FadeOutUp projects =  new FadeOutUp(node);
            if(i != 0) {
                projects.setDelay(new Duration(startPoint));
            }
            projects.setSpeed(speed);
            if(i != controller.sideMenu.getChildren().size() -1) {
                projects.setOnFinished(e -> jarvisSound.boot2());
            }
            projects.play();
            startPoint = startPoint + interval;
            i++;
        }

    }



    public void minAndMaxJarvis(){
        jarvisSound.jarvisEnterAndExit();
        if(controller.isJarvis == true) {
            // jarvis
            new FadeOutRight(controller.jarvis).setSpeed(3).play();
            FadeOutUp fadeJarvis  = new FadeOutUp(controller.jarvis);
            fadeJarvis.setSpeed(3);
            fadeJarvis.setOnFinished(e -> controller.rootPane.setCenter(null));
            fadeJarvis.play();

            // mini jarvis
            new FadeInRightBig(controller.miniJarvis).setSpeed(1.5).play();
            new FadeInDown(controller.miniJarvis).setSpeed(1.5).play();
            new Pulse(controller.miniJarvis).setSpeed(1).play();
            controller.miniJarvis.setOpacity(1);
            controller.isJarvis = false;
        }else{
            // min jarvis
            controller.miniJarvis.setOpacity(0);
            new FadeOutRight(controller.miniJarvis).setSpeed(3).play();
            new FadeOutUp(controller.miniJarvis).setSpeed(3).play();

            // jarvis
            controller.rootPane.setCenter(controller.jarvis);
            new FadeInRightBig(controller.jarvis).setSpeed(1.5).play();
            new FadeInDown(controller.jarvis).setSpeed(1.5).play();
            new Pulse(controller.jarvis).setSpeed(1).play();
            controller.isJarvis = true;
        }
    }

    public void minAndMaxJarvis(Node obj) {

        controller.isJarvis = false;
        if(controller.miniJarvis.getOpacity() != 1) {
            new FadeInRightBig(controller.miniJarvis).setSpeed(1.5).play();
            new FadeInDown(controller.miniJarvis).setSpeed(1.5).play();
            new Pulse(controller.miniJarvis).setSpeed(1).play();
        }
        // jarvis
        controller.miniJarvis.setOpacity(1);
        new FadeOutRight(controller.jarvis).setSpeed(3).play();
        FadeOutUp fadeJarvis = new FadeOutUp(controller.jarvis);
        fadeJarvis.setSpeed(3);
        fadeJarvis.setOnFinished(e -> controller.rootPane.setCenter(obj));
        fadeJarvis.play();
        //jarvisSound.jarvisEnterAndExit();


        }




        // Project menu

    public void unloadSlideMenu(int start, int interval,double speed){
        int startPoint = start;
        int i = 0;
        jarvisSound.boot2();

        ObservableList<Node> projectsBtn = FXCollections.observableArrayList(
                controller.sideMenu.getChildren().sorted()
        );

        Collections.reverse(projectsBtn);


        for(Node node : projectsBtn) {
            FadeOutLeft projects =  new FadeOutLeft(node);
            if(i != 0) {
                projects.setDelay(new Duration(startPoint));
            }
            projects.setSpeed(speed);
            if(i != controller.sideMenu.getChildren().size() - 1) {
                projects.setOnFinished(e -> jarvisSound.boot2());
            }
            projects.play();
            startPoint = startPoint + interval;
            i++;
        }



    }


    public void loadSlideMenu(int start, int interval , double speed){
        int startPoint = start;
        int i = 0;
        for(Node node : controller.sideMenu.getChildren().sorted()) {
            FadeInLeft projects =  new FadeInLeft(node);
            if(i != 0) {
                projects.setDelay(new Duration(startPoint));
            }
            projects.setSpeed(speed);
            if(i != controller.sideMenu.getChildren().size() - 1) {
                projects.setOnFinished(e -> jarvisSound.boot2());
            }
            projects.play();
            startPoint = startPoint + interval;
            i++;
        }
    }

}

