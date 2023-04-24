package sound;

import javax.sound.sampled.*;
import java.io.File;
public class Sound {

    private static Clip clip;

    public static void setFile(String fileName) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            clip = AudioSystem.getClip();
            clip.open(ais);
        }

        catch(Exception e) {}
    }

    public static void play() {
        // This will reset the clip;
        clip.setFramePosition(0);

        // play the clip;
        clip.start();
    }

    public static void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stop() {
        clip.stop();
    }
}
