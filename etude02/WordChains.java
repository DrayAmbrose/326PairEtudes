/**
 * Etude02 WordChains
 * Filename: WordChains.java
 * COSC326 Semester 1
 * 11th March 2021
 * @author Dray Ambrose 9742599
 * @author Jayden Prakash 4718680 
*/

import java.util.*;
import java.lang.StringBuilder;

public class WordChains{

    public static void main(String[] args){
        getInput();
        
    }

     private static void getInput(){
        Scanner input = new Scanner(System.in);
    ArrayList<String> problems = new ArrayList<>();
    while (input.hasNextLine()) {
      String prob = input.nextLine();
      if (prob.trim().equals("")) {
        break;
      }
      problems.add(prob);
    }
    ArrayList<String> words = new ArrayList<>();
    while (input.hasNextLine()) {
      words.add(input.nextLine());
    }
    for(String x: words){
            System.out.println(x);
        }

     }
}