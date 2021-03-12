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
    private static String[] words;
    private static String[] inputs;

    public static void main(String[] args){
        getInput();
    }

     private static void getInput(){
        Scanner scan = new Scanner(System.in);
        /*Array lists to temporarily store the inputs and the list of words to use*/
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String> wlist = new ArrayList<String>();
        /*Iterate through file while it has lines and add the lines to respective array lists*/
        while(scan.hasNextLine()){
            String winput =scan.nextLine();
            int n =0;
            /*Once the file reaches a blank line, it begins adding lines to the word list array*/
            if(winput.equals("")){
                n=1;
                while(scan.hasNextLine()){
                    winput = scan.nextLine();
                    wlist.add(winput.toLowerCase());
                }
            }
            if(n==0){ //As long as the blank line has not been encountered, keep adding words to the inputs array
                input.add(winput.toLowerCase());
            }
        }
        /* Convert array lists into string arrays */
        words = new String[wlist.size()];
        words = wlist.toArray(words);

        inputs = new String[input.size()];
        inputs= input.toArray(inputs);

     }
}