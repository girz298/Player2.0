package AppPackage;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class AllFileInTheDirModel extends AbstractListModel{
    public AllFileInTheDirModel() {
    }
    
    ArrayList<String> listOfSongs=new ArrayList<String>();
    ArrayList<String> listOfPaths=new ArrayList<String>();
        
    
    public void addData(File myFile) {
        listOfSongs.add(myFile.getName().replaceFirst(".mp3", ""));
        listOfPaths.add(myFile.toString());
        
    }

    public String getPath(int index)
    {
    return listOfPaths.get(index);
    }
    
   
    
    public void removeAllData()
    {
        listOfPaths.removeAll(listOfPaths);
        listOfSongs.removeAll(listOfSongs);
    }
    
    
    public void addArraydataToPlaylist(ArrayList<File> listOfData)
    {
        for(int i = 0;i<listOfData.size();i++)
        {
            listOfPaths.add(listOfData.get(i).toString());
            listOfSongs.add(listOfData.get(i).getName().replaceFirst(".mp3", ""));
        
        }
    
    }
    
    
    @Override
    public int getSize() {
        return listOfSongs.size();
        
    }

    public ArrayList<String> getListOfSongs() {
        return listOfSongs;
    }

    public void setListOfSongs(ArrayList<String> listOfSongs) {
        this.listOfSongs = listOfSongs;
    }

    public ArrayList<String> getListOfPaths() {
        return listOfPaths;
    }

    public void setListOfPaths(ArrayList<String> listOfPaths) {
        this.listOfPaths = listOfPaths;
    }

    @Override
    public Object getElementAt(int index) {
      return listOfSongs.get(index);
       
    }
    
    
    
}
