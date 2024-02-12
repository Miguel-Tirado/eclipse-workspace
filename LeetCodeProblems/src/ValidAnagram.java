import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		
		boolean ana = isAnagram(s,t);
		
		System.out.println(ana);

	}
	
	public static boolean isAnagram(String s, String t) {
		//convert String to character array
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		
		if (s.length() != t.length()) {
			return false;
		}
		
		// Sort the character arrays in or to compare 
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		// Compare both to see if they are equal
		return Arrays.equals(sArray, tArray);
	}

}
