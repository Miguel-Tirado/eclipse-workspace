import java.util.HashMap;

public class LongestSubstringK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MergeIntervalsLS sol = new MergeIntervalsLS();
        System.out.println("Length of the longest substring: "
                + sol.findLength("araaci", 2));
        System.out.println("Length of the longest substring: "
                + sol.findLength("araaci", 1));
        System.out.println("Length of the longest substring: "
                + sol.findLength("cbbebi", 3));

	}
	


}

class MergeIntervalsLS {
	public int findLength(String str, int k) {
		// Edge cases
		if (str == null || str.length() == 0 || str.length() < k) {
			throw new IllegalArgumentException();
		}
		
		// Declare Variables 
		int maxLength = 0;
		int windowStart = 0;
		HashMap <Character, Integer> charFreq = new HashMap<>();
		
		// WindowEnd also acts like the index i would for for loops
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			// Map out the character and then frequency of that character 
			// <Character (a,b,c,...), Integer # of occurrences of that number>
			charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0) + 1);
			// part of inserting character UNTIL we have k distinct characters in the HashMap 
			// part of shrink the window from the begining
			while (charFreq.size() > k) {
				// Keep adding one character in the sliding window (hashmap), Slide 
				// The window ahead 
				char leftChar = str.charAt(windowStart);
				charFreq.put(leftChar, charFreq.get(leftChar) - 1);
				if(charFreq.get(leftChar) == 0) {
					charFreq.remove(leftChar);
				}
				windowStart++;
				
			}
			// remember the length of the current window and store the max one
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
			
		}
		return maxLength;
	}
}
