
import java.io.FileInputStream;
import java.io.IOException;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filipe.nisis
 */
public class Music {
    
    public static void main(String[] args) {
        // TODO code application logic here
        music();
    }
    
    public static void music() {
        
        AudioPlayer MGP = AudioPlayer.player;  
        AudioStream BGM = null;  
        AudioData MD = null;  
        //ContinuousAudioDataStream loop = null;  
  
        try {
            System.out.println("g");
            BGM = new AudioStream(new FileInputStream("C:\\Users\\ve.wav")); /*(new FileInputStream("C:\\vera.wav"))*/  
            System.out.println("g1");
            MD = BGM.getData();
            System.out.println("g2");
           

             
            System.out.println("g3");
            
        } catch(IOException error)  {  
            System.out.println("Error!!!");  
  
        } 
            MGP.start(new AudioDataStream(MD));
        
        }
    
}
