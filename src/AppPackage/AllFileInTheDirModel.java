package AppPackage;


import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SuperUser
 */
public class AllFileInTheDirModel extends AbstractListModel{
      /* int number=0;*/
    public AllFileInTheDirModel() {
    }
    
    String string[]=new String[10];
    ArrayList<String> listOfSongs=new ArrayList<String>();
    ArrayList<String> listOfPaths=new ArrayList<String>();
        
    
    public void addData(File myFile) {
   /*    Path myPath;
        myPath.*/
       /* string[number]="111111111111111111";
        number++;*/
               /* listOfSongs.add("asdsad");*/
        listOfSongs.add(myFile.getName().replaceFirst(".mp3", ""));
        listOfPaths.add(myFile.toString());
        
    }

    public String getPath(int index)
    {
    return listOfPaths.get(index);
    }
    
    
    @Override
    public int getSize() {
      /*  return string.length;*/
        return listOfSongs.size();
        
    }

    @Override
    public Object getElementAt(int index) {
        
        /*return string[index];*/
      return listOfSongs.get(index);
       
    }
    
    
    
}
