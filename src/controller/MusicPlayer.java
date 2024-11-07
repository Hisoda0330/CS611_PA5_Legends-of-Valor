package controller;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.File;

public class MusicPlayer {
    private static boolean running = true;

    public static void play() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                playMusic("music.wav");
            }
        }).start();
    }

    public static void stop() {
        running = false;
    }

    private static void playMusic(String musicFilePath) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip.open(inputStream);

            clip.setMicrosecondPosition(0);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            while (running) {
                Thread.sleep(100);
            }

            clip.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println("Failed to play music, " + e.getMessage());
        }
    }
}
