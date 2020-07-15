//Gregory Pierre || EMPLID: 15239799 || CISC 3130- TY2- Fall 2019
import java.util.Stack;
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.util.Comparator;
import java.util.SortedMap; 
import java.util.LinkedHashMap;
import java.util.HashMap;
class Main {

  public static void main(String[] args)throws Exception {
    File file = new File("gucci.txt");

    Scanner scanner = new Scanner(file);
    //Scanner that reads the lyrics of the song
    String wholetext="";
    while(scanner.hasNextLine()){
      String readme = scanner.nextLine();
      wholetext = wholetext+" "+readme;
    }
    //setting a delimiter and setting the words to lowercase
    String [] freq = wholetext.toLowerCase().split(" ");
   System.out.println("This song has a total of " +freq.length+  " words");
    //Created a map to to input word frequency(Word is the key while integer keeps track)
      Map<String, Integer> tracker = new HashMap<>();
        for (String string :freq) {
            if (tracker.containsKey(string)) {
                tracker.put(string, 1 + tracker.get(string));
            } else {
                tracker.put(string, 1);
            }
        }
        //LinkedHashMap to sort the map 
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        tracker.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue())); 
        //Iterator for the map
          sortedMap.forEach((key, value) -> 
          System.out.println(key +":"+ value));          
    }  
}
   
