
package AppPackage.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PlaylistModelOfFile {
   public ArrayList<String> playlistOfSongs =new ArrayList<>();

 
    
    public void savePlaylist(String fileName, ArrayList<String> listOfPaths)
    {
    File file = new File(fileName+".txt");
    try {
        //проверяем, что если файл не существует то создаем его
        if(!file.exists()){
            file.createNewFile();
        }
 
        //PrintWriter обеспечит возможности записи в файл
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
 
        try {
            for(int i = 0;i<listOfPaths.size();i++)
            {
            out.print(listOfPaths.get(i)+";"+"\r\n");
            }
        } finally {
            //После чего мы должны закрыть файл
            //Иначе файл не запишется
            out.close();
        }
    } catch(IOException e) {
        throw new RuntimeException(e);
    }
    
    }
  
    
}
