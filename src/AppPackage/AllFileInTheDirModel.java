package AppPackage;


import AppPackage.model.ModelOfFile;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

public class AllFileInTheDirModel extends AbstractListModel{
    public AllFileInTheDirModel() {
    }
    
    private ModelOfFile modelOffile;
    /*private ArrayList<String> listOfSongs=new ArrayList<String>();*/
    private List<ModelOfFile> listOfPaths=new ArrayList<ModelOfFile>();
   
    
    public void addData(File myFile) {
        modelOffile = new ModelOfFile();
        modelOffile.setPath(myFile.toString());
        modelOffile.setName(myFile.getName().replaceFirst(".mp3", ""));
        /*listOfSongs.add(myFile.getName().replaceFirst(".mp3", ""));
        listOfPaths.add(myFile.toString());*/
        listOfPaths.add(modelOffile);
        
    }

    public String getPath(int index)
    {
    return listOfPaths.get(index).getPath();
    }
    
   
    
    public void removeAllData()
    {
        listOfPaths.removeAll(listOfPaths);
    /*    listOfSongs.removeAll(listOfSongs);*/
    }
    
    
  /*  public void addArraydataToPlaylist(ArrayList<File> listOfData)
    {
        for(int i = 0;i<listOfData.size();i++)
        {
            modelOffile.setPath(listOfData.get(i).toString());
            modelOffile.setName(listOfData.get(i).getName().replaceFirst(".mp3", ""));
            listOfPaths.add(modelOffile);
            listOfPaths.add(listOfData.get(i).toString());
            listOfSongs.add(listOfData.get(i).getName().replaceFirst(".mp3", ""));
        
        }
    
    }*/
    
    
   @Override
    public int getSize() {
        return listOfPaths.size();
        
    }

    public List<ModelOfFile> getListOfSongs() {
        return listOfPaths;
    }

    public void setListOfSongs(List<ModelOfFile> listOfSongs) {
        this.listOfPaths = listOfSongs;
    }

    public List<ModelOfFile> getListOfPaths() {
        return listOfPaths;
    }

    public void setListOfPaths(List<ModelOfFile> listOfPaths) {
        this.listOfPaths = listOfPaths;
    }

    @Override
    public Object getElementAt(int index) {
      return listOfPaths.get(index).getName();
       
    }
    
    
    
}
