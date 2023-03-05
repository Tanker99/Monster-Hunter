import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[3];
    FloatControl fc;

    int volume;
    int volumeScale;

    public Sound() {

        soundURL[0] = Player.class.getResource("/sound/start.wav");
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
    }


    public void play() {

        clip.start();

    }

    public void stop() {
        clip.stop();

    }

    public void loop() {
         clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void volume() {
        switch (volumeScale){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
            fc.setValue(volume);
    }
}


}
