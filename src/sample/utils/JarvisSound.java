package sample.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class JarvisSound {

    public void jarvisEnterAndExit(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0013_cursor_selection_02.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    public void boot1(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_scanner_3.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    public void boot2(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_beep_electric.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    public void boot3(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_beep_electric_2.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    public void buttonClick(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0013_cursor_click_01.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void aINoise(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_type_beep.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(2);
    }




}
