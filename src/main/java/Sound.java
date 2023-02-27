import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[3];

    public Sound() {

        soundURL[0] = Player.class.getResource("/sound/start.wav");
        soundURL[1] = Player.class.getResource("/sound/switch.wav");
        soundURL[2] = Player.class.getResource("/sound/error.wav");

    }
    public void selectSound(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){
            System.out.println("Sound not found");
        }
    }


    public void play(){

        clip.start();

    }
    public void stop(){
        clip.stop();

    }
    public void loop(){
       // clip.loop(100);

    }


}
