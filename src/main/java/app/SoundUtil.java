package app;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class SoundUtil {

    public static void play(String fileName) {
        try {
            // Ambil file dari resources
            InputStream audioSrc = SoundUtil.class.getClassLoader().getResourceAsStream("sound/" + fileName);
            if (audioSrc == null) {
                System.err.println("File tidak ditemukan: " + fileName);
                return;
            }

            // Convert ke audio stream
            InputStream bufferedIn = new java.io.BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
