import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[3];
    FloatControl fc;

    float volume;
    int volumeScale = 3;

    public Sound() {

        soundURL[0] = Player.class.getResource("/sound/Titel-melodie.wav");
        soundURL[1] = Player.class.getResource("/sound/switch.wav");
        soundURL[2] = Player.class.getResource("/sound/error.wav");

    }

    public void selectSound(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {
            System.out.println("Sound not found");
        }
        volume();
    }


    public void play() {
        clip.start();

    }

    public void stop() {
        clip.stop();

    }

    public void loop() {
        fc.setValue(6f);
         clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void volume() {
        switch (volumeScale) {
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
            default:
        }
        fc.setValue(volume);
    }
}


