
/**
 * Etude02 WordChains
 * Filename: WordChains.java
 * COSC326 Semester 1
 * 19th March 2021
 * @author Dray Ambrose 9742599
 * @author Jayden Prakash 4718680 
*/

import java.util.*;

public class WordChains {
  private static HashMap<String, ArrayList<String>> adjacentWords = new HashMap<>(); // contains every word in the
                                                                                     // dictionary and each words
                                                                                     // "adjacent" words

  private static HashSet<String> dictionary = new HashSet<String>();
  private static ArrayList<String> problems = new ArrayList<>();
  private static String path = "";

  public static void main(String[] args) {
    getInput();
    for (String x : problems) {
      int steps = 0;
      if (x.split(" ").length == 3) {
        steps = Integer.parseInt(x.split(" ")[2]);
      }
      String first = x.split(" ")[0];
      String second = x.split(" ")[1];
      if (steps == 0) {
        System.out.println(shortestPath(first, second));
      } else {
        Stack<String> s = new Stack<>();
        System.out.println(fixedPath(s, first, second, steps));
      }
    }

  }

  private static void getInput() {
    Scanner input = new Scanner(System.in);
    while (input.hasNextLine()) {
      String prob = input.nextLine();
      if (prob.trim().equals("")) {
        break;
      }
      problems.add(prob);
    }

    while (input.hasNextLine()) {
      String word = input.nextLine();
      dictionary.add(word);
      adjacentWords.put(word, new ArrayList<String>());

    }
    input.close();
    int dCount; // Count lettter differences
    for (String key : adjacentWords.keySet()) {

      for (int i = 0; i < key.length(); i++) {
        char[] keys = key.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
          keys[i] = c;
          String word = String.valueOf(keys);
          if (dictionary.contains(word)) {
            adjacentWords.get(key).add(word);
          }
        }
      }
    }
  }

  // for(String word: dictionary){
  // dCount = 0;
  // char[] wordArr = word.toCharArray();

  // for(int i = 0; i < word.length(); i++){
  // if(keys.length != word.length()){
  // break;
  // }else if(keys[i] != wordArr[i]) // If letters differ, increment the diff
  // count
  // dCount++;
  // }
  // if(dCount==1){ //If the difference is 1 then the words are 'adjacent'
  // dictionaryMap.get(key).add(word);
  // System.out.println(key + " " + word);

  // }
  // }
  // }
  // }

  public static String shortestPath(String word1, String word2) {
    HashMap<String, Boolean> usedWords = new HashMap<>();
    if (word1.equals(word2)) {
      return word1 + " " + word2;
    }

    ArrayList<Set<String>> adjacencyList = new ArrayList<>();
    if (dictionary.contains(word1) && dictionary.contains(word2)) {
      if (adjacentWords.get(word1).size() == 0 || adjacentWords.get(word2).size() == 0) {
        return word1 + " " + word2 + " impossible";
      }
      adjacencyList.add(new TreeSet<String>());
      adjacencyList.get(0).add(word1);
      boolean found = false;
      int usedWordsCount = -1;

      while (!found) {
        if (usedWords.size() == usedWordsCount) {
          return word1 + " " + word2 + " impossible";
        } else {
          usedWordsCount = usedWords.size();
        }
        Set<String> nextLevel = new TreeSet<>(); // handles next level of the tree

        for (Set<String> level : adjacencyList) {// for each level of the adjacency list
          for (String w : level) { // for each word in the current level of the tree
            if (!usedWords.containsKey(w)) {
              usedWords.put(w, true);
              for (String k : adjacentWords.get(w)) {
                nextLevel.add(k);
              }
            }
          }
        }
        if (nextLevel.contains(word2)) {
          found = true;
          adjacencyList.add(nextLevel);
        } else {
          adjacencyList.add(nextLevel);
        }
      }

      ArrayList<String> wordChain = new ArrayList<>();
      String currentWord = word2;
      for (int i = adjacencyList.size() - 2; i >= 0; i--) {
        wordChain.add(currentWord);
        for (String s : adjacencyList.get(i)) {
          if (adjacentWords.get(s).contains(currentWord)) {
            currentWord = s;
            break;
          }
        }
      }
      wordChain.add(word1);
      String chain = "";
      for (int i = wordChain.size() - 1; i >= 0; i--) {
        chain += wordChain.get(i) + " ";
      }
      return chain;
    } else {
      return word1 + " " + word2 + " impossible";

    }

  }

  public static Stack<String> fixedPath(Stack<String> s, String word1, String word2, int steps) {
    s.push(word1);
    System.out.println(s.size());
    while(s.size() <= steps - 1) {
      for (String w : adjacentWords.get(word1)) {
        if (!s.contains(w) && w != word2) {
          s.push(w);
          fixedPath(s, w, word2, steps);
        }
      }
    }
    return s;
  }
}