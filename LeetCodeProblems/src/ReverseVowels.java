import java.io.*;
import java.util.*;

public class ReverseVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseVowels(String s) {
	    // TODO: Write your code here
	    Stack <Character> stack = new Stack <Character>();
	    StringBuffer string = new StringBuffer(s); 
	    String low = s.toLowerCase();
	    for(int i = 0; i < s.length(); i++){
	      if(low.charAt(i) == 'a' || low.charAt(i) == 'e' || low.charAt(i) == 'i' || low.charAt(i) == 'o' || low.charAt(i) == 'u') {
	        stack.push(s.charAt(i));
	      }
	    }
	
	    for(int j = 0; j < s.length(); j++) {
	      if(low.charAt(j) == 'a' || low.charAt(j) == 'e' || low.charAt(j) == 'i' || low.charAt(j) == 'o' || low.charAt(j) == 'u') {
	        string.setCharAt(j,stack.pop());
	      }
	    }
	    s = string.toString();
	    return s;
    }

}
