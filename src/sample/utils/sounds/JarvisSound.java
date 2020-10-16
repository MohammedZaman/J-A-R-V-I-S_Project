package sample.utils.sounds;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class JarvisSound {


    private static JarvisSound jarvisSound;
    private int volume;
    private MediaPlayer mediaPlayer;

    private JarvisSound (){
        volume = 7;
    }

    public static JarvisSound getInstance(){
        if (jarvisSound == null) {
            jarvisSound = new JarvisSound();
        }
        return jarvisSound;
    }

    public void jarvisEnterAndExit(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0013_cursor_selection_02.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
    public void boot1(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_scanner_3.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
    public void boot2(){
        Media hit = new Media(new File("src/media/effects/slide_effect.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
    public void boot3(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_beep_electric_2.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public void boot4(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_beep_electric.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public void boot5(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0013_cursor_selection_07.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public void boot6(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0013_move_cursor_13.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.setStopTime(new Duration(700));
        mediaPlayer.play();
    }
    public void buttonClick(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0013_cursor_click_01.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public void aINoise(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_type_beep.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(2);
    }

    public void bootBackground(){
        Media hit = new Media(new File("src/media/effects/PremiumBeat_0046_sci_fi_device_3.mp3").toURI().toString());
        MediaPlayer bkMediaPlayer = new MediaPlayer(hit);
        bkMediaPlayer.setVolume(5);
        bkMediaPlayer.setStartTime(new Duration(200));
        bkMediaPlayer.setStopTime(new Duration(7700));
        bkMediaPlayer.play();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }




}
