package Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {
    private Clip clip;
    private Clip loopClip;
    private URL[] soundURL = new URL[4];
    private URL[] loopURL = new URL[4];
    private FloatControl fc;
    private FloatControl loopFc;
    private float volume = 1f;
    private float loopVolume = 1f;




    public Sound() {
        loopURL[0] = Sound.class.getResource("/sound/Titel-melodie.wav");
        //Select Game.Sound
        soundURL[1] = Sound.class.getResource("/sound/switch.wav");
        //Not Select Allow Game.Sound
        soundURL[2] = Sound.class.getResource("/sound/error.wav");
        //Enter Game.Sound
        soundURL[3] = Sound.class.getResource("/sound/switch.wav");
    }

    public void playSound(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

    public void playLoop(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(loopURL[i]);
            loopClip = AudioSystem.getClip();
            loopClip.open(ais);
            loopFc = (FloatControl) loopClip.getControl(FloatControl.Type.MASTER_GAIN);
            loopClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public void setVolume(int i) {
        if (fc != null) {
           switch (i) {
                case 0:
                    volume = -80f;
                    break;
                case 1:
                    volume = -40f;
                    break;
                case 2:
                    volume = -20f;
                    break;
                case 3:
                    volume = 1f;
                    break;
                case 4:
                    volume = 6f;
                    break;
            }
            fc.setValue(volume);
        }
    }

    public void setLoopVolume(int i ) {
        if (loopFc != null) {
            switch (i) {
                case 0:
                    loopVolume = -80f;
                    break;
                case 1:
                    loopVolume = -40f;
                    break;
                case 2:
                    loopVolume = -20f;
                    break;
                case 3:
                    loopVolume = 1f;
                    break;
                case 4:
                    loopVolume = 6f;
                    break;
                }
            loopFc.setValue(loopVolume);
        }
    }
}