package sample.utils.sounds;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class JarvisVoice {


    private static JarvisVoice jarvisVoice;
    private int volume;
    private MediaPlayer mediaPlayer;

    private JarvisVoice (){
        volume = 10;
    }

    public static JarvisVoice getInstance(){
        if (jarvisVoice == null) {
            jarvisVoice = new JarvisVoice();
        }
        return jarvisVoice;
    }

    // voice remove
    public void  bootUp() {
        Media hit = new Media(new File("src/media/voices/boot-up.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
}