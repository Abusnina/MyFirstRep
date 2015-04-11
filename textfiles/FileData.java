/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfiles;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ali
 */
public class FileData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/Ali/Desktop/Test.txt";
         try {
              ReadFile file = new ReadFile(fileName);
              String[] arryLines = file.openfile();
              MaxDuplicateWordCount mdc = new MaxDuplicateWordCount();
              Map<String, Integer> myTable = mdc.getWordCount(fileName);
              List<Map.Entry<String, Integer>> list = mdc.sortByValue(myTable);
               
             // System.out.println("The most repeated word in your Film is: " + list.getKey(0));

              for(Map.Entry<String, Integer> entry:list.subList(0, 1)){
                   System.out.println("The most repeated word in your Film is: " +entry.getKey()+","+ " and it was repeated: "+entry.getValue() + " time");
                }
                
                   
              
                    
            }
          catch (IOException e){
                System.out.println( e.getMessage() );   
                }
    }  
}
