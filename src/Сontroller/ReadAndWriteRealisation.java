
package Сontroller;

import AppPackage.model.ModelOfFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteRealisation {
     private BufferedReader BufferedFileInputStream;    
     private StringBuffer stringBuff;
     private String str;
     private List<ModelOfFile> listOfPatFilesh=new ArrayList<ModelOfFile>();
     private String stopString;
     
     
    
    public void savePlaylist(String fileName, List<ModelOfFile> listOfPaths)
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
            out.print(listOfPaths.get(i).getPath()+";"/*+"\r\n"*/);
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
    
    public List<ModelOfFile> openPlayList(String pathOfPlayList) throws IOException
    {
        listOfPatFilesh.removeAll(listOfPatFilesh);
        int end;
        ModelOfFile modelOfFile;
        int nameID=0;
       BufferedFileInputStream = new BufferedReader(new InputStreamReader(new FileInputStream(pathOfPlayList)));
        while((str=BufferedFileInputStream.readLine())!=null)
            stringBuff = new StringBuffer(str);
        BufferedFileInputStream.close();
        
        
         while(true){
             try {
                 end=stringBuff.indexOf(";");
             modelOfFile=new ModelOfFile();
             modelOfFile.setPath(stringBuff.subSequence(0, end).toString());
             for(int i=end;i>0;i--){
                 if(stringBuff.charAt(i)=='\\'){
                 nameID=i;
                 break;
                 }
                 
             }
             modelOfFile.setName(stringBuff.subSequence(nameID+1, end).toString().replaceFirst(".mp3", ""));
             listOfPatFilesh.add(modelOfFile);
               
             stringBuff.delete(0, end+1);
             } catch (Exception e) {
                 break;
             }
             
             
         }
                System.out.println("dsikj");
        return listOfPatFilesh;
    }
  
    
}
