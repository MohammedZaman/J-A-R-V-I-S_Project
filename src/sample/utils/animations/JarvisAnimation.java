package sample.utils.animations;

import animatefx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.util.Duration;
import sample.Controller;
import sample.utils.sounds.JarvisSound;
import sample.utils.sounds.JarvisVoice;


import java.util.*;

public class JarvisAnimation {

    Controller controller;
    JarvisSound jarvisSound;
    JarvisVoice jarvisVoice;
    public JarvisAnimation (Controller controller){
        this.controller = controller;
        this.jarvisSound =  JarvisSound.getInstance();
        this.jarvisVoice = JarvisVoice.getInstance();

    }

    public void BootUp(){
        jarvisSound.bootBackground();
        controller.rootPane.setCenter(controller.jarvis);

        controller.jarvis.setOpacity(0);
        FadeIn  jarvisAnim =   new FadeIn(controller.jarvis);
        jarvisAnim.setSpeed(1);
        jarvisAnim.setDelay(new Duration(4000));
        jarvisAnim.setOnFinished(e -> bootUp());
        jarvisAnim.play();
        loadMainMenu(6500,400,1.5);
        loadSlideMenu(6500,100,3);




        FadeInUpBig stark = new FadeInUpBig(controller.starkIndustry);
        stark.setSpeed(2);
        //stark.setOnFinished(e -> close());
        stark.setDelay(new Duration(6500));
        stark.play();

    }

    private void bootUp(){
        jarvisSound.boot3();
        jarvisVoice.bootUp();
    }
    private void close(){
        jarvisSound.boot4();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                unloadSlideMenu(100,200,1);
                minAndMaxJarvis();
            }
        }, 1500);

    }
    private boolean loadMainLock = false;
    public void loadMainMenu(int start, int interval,double speed){
        if(loadMainLock  == false && unloadMainLock == false) {
            loadMainLock = true;
            int startPoint = start;
            int i = 0;
            for (Node node : controller.topMenu.getChildren().sorted()) {
                FadeInUp projects = new FadeInUp(node);
                projects.setDelay(new Duration(startPoint));
                projects.setSpeed(speed);
                if ((i % 1) == 0) {
                    projects.setOnFinished(e -> jarvisSound.boot6());
                }
                if (i == controller.topMenu.getChildren().size() - 1) {
                    projects.setOnFinished(e -> loadMainLock = false);
                }
                projects.play();
                startPoint = startPoint + interval;
                i++;
            }
        }

    }


    private boolean unloadMainLock = false;
    public void unloadMainMenu(int start, int interval,double speed){

        if(loadMainLock  == false && unloadMainLock == false) {
            unloadMainLock = true;
            int startPoint = start;
            int i = 0;
            jarvisSound.boot2();

            ObservableList<Node> projectsBtn = FXCollections.observableArrayList(
                    controller.topMenu.getChildren().sorted()
            );

            Collections.reverse(projectsBtn);


            for (Node node : projectsBtn) {
                FadeOutUp projects = new FadeOutUp(node);
                if (i != 0) {
                    projects.setDelay(new Duration(startPoint));
                }
                projects.setSpeed(speed);
                if ((i % 1) == 0) {
                    projects.setOnFinished(e -> jarvisSound.boot6());
                }
                if (i == projectsBtn.size() - 1) {
                    projects.setOnFinished(e -> unloadMainLock = false);
                }
                projects.play();
                startPoint = startPoint + interval;
                i++;
            }
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

    private boolean unloadSideLock = false;
    public void unloadSlideMenu(int start, int interval,double speed){
        if(unloadSideLock == false && loadSideLock == false) {
            unloadSideLock = true;
            int startPoint = start;
            int i = 0;
            jarvisSound.boot2();

            ObservableList<Node> projectsBtn = FXCollections.observableArrayList(
                    controller.sideMenu.getChildren().sorted()
            );

            Collections.reverse(projectsBtn);


            for (Node node : projectsBtn) {
                FadeOutLeft projects = new FadeOutLeft(node);
                projects.setDelay(new Duration(startPoint));
                projects.setSpeed(speed);
//                if ((i % 2) == 0) {
//                    projects.setOnFinished(e -> jarvisSound.boot6());
//                }
                if (i == projectsBtn.size() - 1) {
                    projects.setOnFinished(e -> unloadSideLock = false);
                }
                projects.play();
                startPoint = startPoint + interval;
                i++;

            }
        }

    }

    private boolean loadSideLock = false;
    public void loadSlideMenu(int start, int interval , double speed){
        if(unloadSideLock == false && loadSideLock == false) {
            loadSideLock = true;
            int startPoint = start;
            int i = 0;
            for (Node node : controller.sideMenu.getChildren()) {
                FadeInLeft projects = new FadeInLeft(node);
                projects.setDelay(new Duration(startPoint));
                projects.setSpeed(speed);
//                if ((i % 2) == 0) {
//                    projects.setOnFinished(e -> jarvisSound.boot6());
//                }
                if (i == controller.sideMenu.getChildren().size() - 1) {
                    projects.setOnFinished(e -> loadSideLock = false);
                }
                projects.play();
                startPoint = startPoint + interval;
                i++;
            }
        }
    }

}

