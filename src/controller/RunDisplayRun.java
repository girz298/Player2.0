package controller;

import static view.MP3PlayerGUI.Display;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JLabel;

public class RunDisplayRun   {
    String text;
    boolean movingLabel;
    public Thread moveThread;
    public int someInteger=-1;
    public char[] charArray;
    public char[] charArray2;
    public Queue<Character> queue = new LinkedList<Character>();
    public RunDisplayRun(String text ) {
          movingLabel=false;
        this.text=text;
        
    }
    
    public void StopMoving(JLabel display)
    {
       
        movingLabel=false;
          moveThread.stop();
    }
    
    public boolean isActive()
    {
    return movingLabel;
    }
    
    public void  Move(JLabel display)
    {
       movingLabel=true;
       text.length();
        moveThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                for(;;){
               charArray = text.toCharArray();

                if(someInteger==text.length()-1)
                {
                    queue.add(queue.remove());

                }else{ someInteger++; queue.add(charArray[someInteger]);} 
                 display.setText(queue.toString().replace(',','\0'));
                try {
                    Thread.sleep(150);
                } 
                catch (InterruptedException ex) 
                {
                }
                }
            }
        });
      moveThread.start();
      
    }
}
