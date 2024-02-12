import java.util.HashSet;

public class Panagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "The quick brown fox jumps over the lazy dog";
		if (checkIfPanagram(sentence) == true) {
			System.out.print(sentence + "\nis a pangram.");
		} else {
			System.out.print(sentence + "\nis not pangram.");
		}
			
	}
	
	public static boolean checkIfPanagram(String sentence) {
	     boolean[] mark = new boolean[26];
	     int index = 0;

	     for (int i = 0; i < sentence.length(); i++) {
	      if('A' <= sentence.charAt(i) && sentence.charAt(i) <= 'Z') {
	        index = sentence.charAt(i) - 'A';
	      } else if ('a' <= sentence.charAt(i) && sentence.charAt(i) <= 'z') {
	        index = sentence.charAt(i) - 'a';
	      } else {
	        continue;
	      }
	      mark[index] = true; 
	     }

	     for (int j = 0; j <= 25; j++) {
	      if(mark[j] == false) {
	        return false;
	      }
	     }
	    return true;
	}
	
	public static boolean checkIfPangram2(String sentence) {
	    // Create a set to store unique characters
	    HashSet<Character> seen = new HashSet<>();

	    // Convert sentence to lowercase and iterate over each character
	    for (char currChar : sentence.toLowerCase().toCharArray()) {
	        if (Character.isLetter(currChar)) {
	          // Add the character to set
	          seen.add(currChar);
	      }
	    }

	    // Return true if set size is 26 (total number of alphabets)
	    return seen.size() == 26;
	}
}

/*
 * class MergeIntervals {
  public boolean checkIfPangram(String sentence) {
    HashSet<Character> check = new HashSet<Character>();
    for (int i = 0; i < sentence.length(); i++) {
      if ('A' <= sentence.charAt(i) && sentence.charAt(i) <= 'Z') {
        check.add(sentence.toLowerCase().charAt(i));
      } else if ('a' <= sentence.charAt(i) && sentence.charAt(i) <= 'z') {
        check.add(sentence.toLowerCase().charAt(i));
      } else {
        continue;
      }
      
    }
    if (check.size() == 26) {
      return true;
    } else {
      return false;
    }
    
  }
}
 */

