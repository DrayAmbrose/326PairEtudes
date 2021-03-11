/**
 * Etude02 WordChains
 * Filename: WordChains.java
 * COSC326 Semester 1
 * 11th March 2021
 * @author Dray Ambrose 9742599
 * @author Jayden Prakash 4718680 
*/

import java.util.*;

public class WordChains{
    private static String[] words;

    public static void main(String[] args){
        getInput();
    }

     private static void getInput(){
        Scanner scan = new Scanner(System.in);
	
        ArrayList<String> input = new ArrayList<String>();
        int i = 0;
	
        while(scan.hasNextLine()){
            input.add(scan.nextLine().toLowerCase());
            i++;
        }
        words = new String[input.size()];
        words = input.toArray(words); 
        for (String x:words){
                System.out.println(x);
            }
        }
}