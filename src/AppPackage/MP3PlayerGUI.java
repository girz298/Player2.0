package AppPackage;

//All code is added to create the widget. Follow the "Create a Widget" tutorial if you want to know how I did it.

import AppPackage.model.PlaylistModelOfFile;
import AppPackage.model.RunDisplayRun;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import static java.lang.System.exit;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class MP3PlayerGUI extends javax.swing.JDialog 
{   
    private AllFileInTheDirModel modelFromList = new AllFileInTheDirModel() ;
    private File myFile;
    private RunDisplayRun RDR = new RunDisplayRun("");
    private PlaylistModelOfFile playListFile = new PlaylistModelOfFile();
    private Thread movingNameThread;
    private String newDirOfFiles="";
    private MainClass MC = new MainClass();
    private static int count;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MP3PlayerGUI.count = count;
    }
    private double lengthOfSongDouble;
    private int lengthOfSong;
    
    private int xMouse;
    private int yMouse;
    
    private int width = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 185;
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height - 180;
    
    public MP3PlayerGUI(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        
        this.setLocation(width, 220);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayList = new javax.swing.JScrollPane();
        PlayList1 = new javax.swing.JList();
        PlayFromMiddleOfFile = new javax.swing.JLabel();
        OpenPlaylistLabel = new javax.swing.JLabel();
        ReturnSlider = new javax.swing.JSlider();
        CloseLabel = new javax.swing.JLabel();
        LoopPosition = new javax.swing.JLabel();
        Display = new javax.swing.JLabel();
        Play = new javax.swing.JLabel();
        SelectFile = new javax.swing.JLabel();
        Pause = new javax.swing.JLabel();
        Stop = new javax.swing.JLabel();
        Loop = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MP3 Player");
        setFocusableWindowState(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlayList1.setBackground(new java.awt.Color(204, 153, 0));
        PlayList1.setFont(new java.awt.Font("MingLiU_HKSCS", 3, 18)); // NOI18N
        PlayList1.setModel(modelFromList);
        PlayList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                PlayList1ValueChanged(evt);
            }
        });
        PlayList.setViewportView(PlayList1);

        getContentPane().add(PlayList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 330, 260));

        PlayFromMiddleOfFile.setText("К центру");
        PlayFromMiddleOfFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayFromMiddleOfFileMouseReleased(evt);
            }
        });
        getContentPane().add(PlayFromMiddleOfFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        OpenPlaylistLabel.setText("Сохранить в файл");
        OpenPlaylistLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OpenPlaylistLabelMouseReleased(evt);
            }
        });
        getContentPane().add(OpenPlaylistLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, -1, -1));

        ReturnSlider.setBackground(new java.awt.Color(204, 102, 0));
        ReturnSlider.setMaximum(350);
        ReturnSlider.setValue(1);
        ReturnSlider.setOpaque(false);
        ReturnSlider.setRequestFocusEnabled(false);
        ReturnSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ReturnSliderMouseReleased(evt);
            }
        });
        getContentPane().add(ReturnSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 350, 30));

        CloseLabel.setBackground(new java.awt.Color(153, 153, 0));
        CloseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CloseLabelMouseReleased(evt);
            }
        });
        getContentPane().add(CloseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 0, 30, 30));

        LoopPosition.setFont(new java.awt.Font("Utsaah", 3, 14)); // NOI18N
        LoopPosition.setForeground(new java.awt.Color(0, 0, 204));
        LoopPosition.setText("OFF");
        getContentPane().add(LoopPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 30, 20));

        Display.setFont(new java.awt.Font("Gungsuh", 2, 14)); // NOI18N
        getContentPane().add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 350, 20));

        Play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayMouseReleased(evt);
            }
        });
        getContentPane().add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, 83));

        SelectFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SelectFileMouseReleased(evt);
            }
        });
        getContentPane().add(SelectFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 40, 40));

        Pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PauseMouseReleased(evt);
            }
        });
        getContentPane().add(Pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 50, 70));

        Stop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StopMouseReleased(evt);
            }
        });
        getContentPane().add(Stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 70, 60));

        Loop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LoopMouseReleased(evt);
            }
        });
        getContentPane().add(Loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 40, 40));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Background3.png"))); // NOI18N
        Background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackgroundMouseDragged(evt);
            }
        });
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackgroundMousePressed(evt);
            }
        });
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 500));
        Background.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_BackgroundMouseDragged

    private void BackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_BackgroundMousePressed

    private void StopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopMouseReleased
        MC.Stop();
        RDR.StopMoving(Display);
    }//GEN-LAST:event_StopMouseReleased

    private void PlayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseReleased
        MC.Resume();
    }//GEN-LAST:event_PlayMouseReleased

    private void PauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PauseMouseReleased
        MC.Pause();;
    }//GEN-LAST:event_PauseMouseReleased

    private void SelectFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectFileMouseReleased
        if(newDirOfFiles.equals(""))
        {
        JFileChooser chooser = new JFileChooser();
        int returnVal=chooser.showOpenDialog(null);
        
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {   
                isRDRActive(chooser);
            }
        }else{
        JFileChooser chooser = new JFileChooser(newDirOfFiles);
        int returnVal=chooser.showOpenDialog(null);
        
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {   
                isRDRActive(chooser); 
            }
        }             
    }//GEN-LAST:event_SelectFileMouseReleased

    private void isRDRActive(JFileChooser chooser) {
        if(RDR.isActive())
        {
            RDR.StopMoving(Display);
            MC.Stop();
            myFile = chooser.getSelectedFile();
            String song = myFile + "";
            String name = chooser.getSelectedFile().getName();
            RDR = new RunDisplayRun(name+"     ");
            RDR.Move(Display);
            MC.Play(song);
            MC.rewind(ReturnSlider, ReturnSlider.getValue());
            lengthOfSong=0;
            ReturnSlider.setValue(1);
            lengthOfSong=(int)MC.getSongTotalLength();
            modelFromList.addData(myFile);
            PlayList1.updateUI();
            newDirOfFiles=myFile.getAbsolutePath();
            myFile=null;
        }
        else
        {
            System.out.println(RDR.isActive());
            MC.Stop();
            myFile = chooser.getSelectedFile();
            String song = myFile + "";
            String name = chooser.getSelectedFile().getName();
            RDR = new RunDisplayRun(name+"     ");
            RDR.Move(Display);
            MC.Play(song);
            MC.rewind(ReturnSlider, ReturnSlider.getValue());
            lengthOfSong=0;
            ReturnSlider.setValue(1);
            lengthOfSong=(int)MC.getSongTotalLength();
            modelFromList.addData(myFile);
            PlayList1.updateUI();
            newDirOfFiles=myFile.getAbsolutePath();
            myFile=null;
            
        }
    }
      
 
        
    private void LoopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoopMouseReleased
        switch(count)
        {
            case 0:
                count = 1;
                LoopPosition.setText("On");
                break;
                
            case 1:
                count = 0;
                LoopPosition.setText("Off");
                break;
        }
    }//GEN-LAST:event_LoopMouseReleased

    private void CloseLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseReleased
        System.exit(0);
    }//GEN-LAST:event_CloseLabelMouseReleased

    private void PlayFromMiddleOfFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayFromMiddleOfFileMouseReleased
        MC.Pause();
        System.out.println(ReturnSlider.getValue());
        MC.getTimer().stop();
        MC.rewindSong(lengthOfSong/2);
        ReturnSlider.setValue(175);
        MC.rewind(ReturnSlider, ReturnSlider.getValue());
        MC.getTimer().start();
        
    }//GEN-LAST:event_PlayFromMiddleOfFileMouseReleased

    private void PlayList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_PlayList1ValueChanged
        MC.Pause();
        MC.getTimer().stop();
        RDR.StopMoving(Display);
        MC.Play(modelFromList.getPath(PlayList1.getSelectedIndex()));
        RDR=new RunDisplayRun((String) modelFromList.getElementAt(PlayList1.getSelectedIndex())+"      ");
        RDR.Move(Display);
         MC.rewind(ReturnSlider, ReturnSlider.getValue());
            lengthOfSong=0;
            ReturnSlider.setValue(1);
            lengthOfSong=(int)MC.getSongTotalLength();
            MC.getTimer().start();
            
    }//GEN-LAST:event_PlayList1ValueChanged

    private void ReturnSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnSliderMouseReleased
         MC.Pause();
        System.out.println(ReturnSlider.getValue());
        MC.getTimer().stop();
        MC.rewindSong((lengthOfSong/350)*(long)ReturnSlider.getValue());
        MC.rewind(ReturnSlider, ReturnSlider.getValue());
        MC.getTimer().start();
    }//GEN-LAST:event_ReturnSliderMouseReleased

    private void OpenPlaylistLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenPlaylistLabelMouseReleased
        JFileChooser chooser = new JFileChooser();
        int returnVal=chooser.showOpenDialog(null);
        
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {   
                playListFile.savePlaylist(chooser.getSelectedFile().getAbsolutePath(),modelFromList.getListOfPaths());
            }
     /*   modelFromList.removeAllData();
        PlayList1.updateUI();*/
    }//GEN-LAST:event_OpenPlaylistLabelMouseReleased

    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MP3PlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                MP3PlayerGUI dialog = new MP3PlayerGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() 
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) 
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel CloseLabel;
    public static javax.swing.JLabel Display;
    private javax.swing.JLabel Loop;
    public static javax.swing.JLabel LoopPosition;
    private javax.swing.JLabel OpenPlaylistLabel;
    private javax.swing.JLabel Pause;
    private javax.swing.JLabel Play;
    private javax.swing.JLabel PlayFromMiddleOfFile;
    private javax.swing.JScrollPane PlayList;
    private javax.swing.JList PlayList1;
    private javax.swing.JSlider ReturnSlider;
    private javax.swing.JLabel SelectFile;
    private javax.swing.JLabel Stop;
    // End of variables declaration//GEN-END:variables
}
