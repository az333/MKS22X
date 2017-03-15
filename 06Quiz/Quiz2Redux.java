import java.util.*;
public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
    
  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help( words , s);
      Collections.sort(words);
      return words;
  }
  
    private static void help( ArrayList<String> words, String s){
	words.add("");
	for (int i = 0; i < s.length(); i ++) {
	    int len = words.size();
	    for (int j = 0; j < len; j ++) {
		words.add(words.get(j) + s.charAt(i));
	    } 
	}
    }

    public static void main (String[] args) {

	System.out.println ( combinations ("abcd"));
    } 
    
}



