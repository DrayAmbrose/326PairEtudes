/**
 * Etude02 WordChains
 * Filename: WordChains.java
 * COSC326 Semester 1
 * 19th March 2021
 * @author Dray Ambrose 9742599
 * @author Jayden Prakash 4718680 
*/

import java.util.*;

public class WordChains{

    public static void main(String[] args){
        getInput();
        String str = "Hello I'm your String";
        String[] splited = str.split(" ");
        
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
    for(String x: problems){
      int steps = 0;
      if(x.split(" ").length == 3){
        steps = Integer.parseInt(x.split(" ")[2]);
      }
      String first = x.split(" ")[0];
      String second = x.split(" ")[1];
      findWordChain(first, second, steps);
        }
     }


    private static void findWordChain(String first, String second, int steps){
       System.out.println(first + " " + second + " " + steps);
     }
     }
