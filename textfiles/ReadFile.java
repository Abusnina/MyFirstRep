/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfiles;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Ali
 */
public class ReadFile {
  private  String path;
  
  public ReadFile(String file_path){
      path = file_path;  
  }
  
  public String[] openfile() throws IOException{  
      
      FileReader fr = new FileReader(path);
      BufferedReader textReader = new BufferedReader(fr);
      int numberOfLine = readlines();
      String[] textData = new String[numberOfLine];
      
      
      for(int i=0; i<numberOfLine; i++){
          textData[i] = textReader.readLine(); 
      }
      textReader.close();
      return textData;     
  } 
  
  
  int readlines()throws IOException{
      FileReader file_to_read = new FileReader(path);
      BufferedReader bf = new BufferedReader(file_to_read);
      String aLine;
      int NumberofLine = 0;
      
      while ((aLine = bf.readLine()) != null){
          NumberofLine++;
      }
      bf.close();
      return NumberofLine;    
  }
  
  public Map<String, Integer> getWordCount(String textData){
         Map<String, Integer> wordMap = new HashMap<String, Integer>();
         StringTokenizer st = new StringTokenizer(textData, " ");
          String tmp = st.nextToken().toLowerCase();
          while(st.hasMoreTokens()){
               if(wordMap.containsKey(tmp)){
                  wordMap.put(tmp, wordMap.get(tmp)+1);
               } else {
                  wordMap.put(tmp, 1);
               }
          }
          return wordMap;
  }  
  
   public List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap){
 
        Set<Map.Entry<String, Integer>> set = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        
        Collections.max( list, new Comparator<Map.Entry<String, Integer>>(){
        
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                  return (o2.getValue()).compareTo( o1.getValue() );
            }
         } );
        return list;
        
    }
  
  
}
