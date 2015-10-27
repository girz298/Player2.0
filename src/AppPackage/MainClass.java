package AppPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.FloatControl;
import javax.swing.JSlider;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass 
{
    private FileInputStream FIS;
    private BufferedInputStream BIS;
    private Timer timer;
    private boolean counterOfPlayers=true;

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public long getSongTotalLength() {
        return songTotalLength;
    }

    public void setSongTotalLength(long songTotalLength) {
        this.songTotalLength = songTotalLength;
    }
    private Player player;
    private Thread movingLabelOfPositioon;
    private long pauseLocation;
    private long songTotalLength;
    
    private String fileLocation;
    
    public void Stop()
    {
    if(player != null)
        {
            System.out.println("Position:"+player.getPosition());
          player.close();
          pauseLocation = songTotalLength;
       /*   songTotalLength = 0;*/
          MP3PlayerGUI.Display.setText("");
          timer.stop();
        }   
    }
    
    public void Pause()
    {
    if(player != null)
            {
            try {
                System.out.println(songTotalLength/10000);
                counterOfPlayers=true;
                pauseLocation = FIS.available();
                player.close();
      
            } 
              catch (IOException ex)
            {
            }
        }   
    }
    
    public void Resume()
    {
       if(counterOfPlayers){
        try 
        {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(songTotalLength-pauseLocation);   
        } 
        catch (FileNotFoundException | JavaLayerException ex) {
            
        } 
        catch (IOException ex)
        {

        }
        
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    counterOfPlayers=false;
                    player.play();
                } 
                catch (JavaLayerException ex)
                {
                    
                }
            }
        }.start();}
    } 
    
    
    
    public void rewindSong(long postion)
    {
     try 
        {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            FIS.skip(postion);
        } 
        catch (FileNotFoundException | JavaLayerException ex) {
            
        } 
        catch (IOException ex)
        {

        }
        
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    
                    player.play();
                } 
                catch (JavaLayerException ex)
                {
                    
                }
            }
        }.start();
    
    }
    
    public void rewind(JSlider slider,int valueOfSlider)
   {

       timer = new Timer(1000,new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              
                slider.setValue((int)(slider.getValue()+350/(songTotalLength/10000)));
                   slider.setValue(slider.getValue()+1);
               
           }
           
       });
       timer.start();       
   }

    
    
    
    
    
    
    
    
    public void Play(String path)
    {
        try 
        {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
            songTotalLength = FIS.available();
            fileLocation = path+"";
        } 
        catch (FileNotFoundException | JavaLayerException ex) {
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    counterOfPlayers=false;
                    player.play();
                    
                    if(player.isComplete() && MP3PlayerGUI.getCount()==1)
                    {
                        Play(fileLocation);
                    }
                    if(player.isComplete())
                    {
                        MP3PlayerGUI.Display.setText("");
                    }
                    
                } 
                catch (JavaLayerException ex)
                {
                    
                }
            }
        }.start();
    }
}
