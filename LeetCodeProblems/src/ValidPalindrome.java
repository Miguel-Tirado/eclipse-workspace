
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sent = "tacocat";
		String answer = isPalindrome(sent) ? "is a palindrome" : "is not a palindrome";
		System.out.println("The sentence or word : " + sent + " :" + answer );
	}
	
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("^a-zA-Z0-9","");
		s = s.toLowerCase();
		
		int i = 0;
		int j = s.length() -1 ;
		
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		
		return true;
	}

}
