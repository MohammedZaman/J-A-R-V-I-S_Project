package sample.utils;

import animatefx.animation.*;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sample.Controller;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class JarvisAnimation {

    Controller controller;
    JarvisSound jarvisSound;
    public JarvisAnimation (Controller controller){
        this.controller = controller;
        this.jarvisSound = new JarvisSound();
    }

    public void BootUp(){
        jarvisSound.boot1();
        Timer projectTimer = new Timer();
        projectTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        jarvisSound.boot2();
                        controller.projectsBtn.setOpacity(1);
                        new SlideInDown(controller.projectsBtn).setSpeed(2).play();
                    }
                });

            }
        }, 4800);

        Timer protocolTimer = new Timer();
        protocolTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        jarvisSound.boot2();
                        controller.protocolsBtn.setOpacity(1);
                        new SlideInDown(controller.protocolsBtn).setSpeed(2).play();
                    }
                });

            }
        }, 5300);

        Timer jarvisTimer = new Timer();
        jarvisTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        controller.rootPane.setCenter(controller.jarvis);
                        jarvisSound.boot3();
                        controller.jarvis.setOpacity(1);
                        new FadeIn(controller.jarvis).setSpeed(1).play();
                    }
                });

            }
        }, 6000);

        Timer starkTimer = new Timer();
        starkTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        jarvisSound.boot2();
                        controller.starkIndustry.setOpacity(1);
                        new FadeIn(controller.starkIndustry).setSpeed(2).play();
                    }
                });

            }
        }, 5700);
    }

    public void minAndMaxJarvis(){
        jarvisSound.jarvisEnterAndExit();
        if(controller.isJarvis == true) {
            controller.miniJarvis.setOpacity(1);
            new FadeOutRight(controller.jarvis).setSpeed(3).play();
            new FadeOutUp(controller.jarvis).setSpeed(3).play();
            new FadeInRight(controller.miniJarvis).setSpeed(1.5).play();
            new FadeInDown(controller.miniJarvis).setSpeed(1.5).play();
            new Pulse(controller.miniJarvis).setSpeed(1).play();
            controller.isJarvis = false;
            controller.rootPane.setCenter(null);
        }else{
            controller.jarvis.setOpacity(1);
            new FadeOutRight(controller.miniJarvis).setSpeed(3).play();
            new FadeOutUp(controller.miniJarvis).setSpeed(3).play();
            new FadeInRightBig(controller.jarvis).setSpeed(1.5).play();
            new FadeInDown(controller.jarvis).setSpeed(1.5).play();
            new Pulse(controller.jarvis).setSpeed(1).play();
            controller.isJarvis = true;
            controller.rootPane.setCenter(controller.jarvis);
        }
    }
}
