package AppPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass 
{
    FileInputStream FIS;
    BufferedInputStream BIS;
    public Timer timer;
    public Player player;
    public Thread movingLabelOfPositioon;
    public long pauseLocation;
    public long songTotalLength;
    
    public String fileLocation;
    
    public void Stop()
    {
    if(player != null)
        {
            System.out.println("Position:"+player.getPosition());
          player.close();
          pauseLocation = 0;
         /* songTotalLength = 0;*/
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
                    
                    player.play();
                } 
                catch (JavaLayerException ex)
                {
                    
                }
            }
        }.start();
    } 
    
    
    
    public void PlayFromMiddle(long postion)
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
    
    public void Moving(JSlider slider,int valueOfSlider)
   {

       timer = new Timer(1000,new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              
                slider.setValue((int)(slider.getValue()+350/(songTotalLength/10000)));
               /*    System.out.println((valueInThere+(350/(songTotalLength/10000))));*/
                   slider.setValue(slider.getValue()+1);
               
           }
           
       });
       timer.start();
       
       /*    movingLabelOfPositioon = new Thread(new Runnable() {

           @Override
           public void run() {
               if(RDR.moveThread.isAlive()){
               int valueInThere=valueOfSlider;
               while(valueInThere!=350){
               slider.setValue((int)(valueInThere+350/(songTotalLength/10000)));
                   System.out.println((valueInThere+(350/(songTotalLength/10000))));
                   valueInThere++;
                   try {
                       Thread.sleep(1000);
                   } 
                   catch (InterruptedException ex) 
                   {
                   }
               }
           }
           }
       });
      
       movingLabelOfPositioon.start();*/
       
     
       /*Я это ты не забуть протестироват
       Timer timer = new Timer(1000 , new ActionListener().............. 
       если не получится исправить баг 
       */
       
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
                    player.play();
                    
                    if(player.isComplete() && MP3PlayerGUI.count==1)
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
