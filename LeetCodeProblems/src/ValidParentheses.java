import java.util.Stack;
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Eclipse!");
		
		//String s = "{}()";
		String s2 = "{{}()}";
		//String s3 = "asds";
		System.out.println(isValid(s2));
		//System.out.println(isValid(s2));
		//System.out.println(isValid(s3));
		/*
		char t1 = '{';
		char t2 = '}';
		
		if (t2 != t1) {
			System.out.println("we in the block");
		} */
	}
	
	public static boolean isValid(String s) {
		// Initialize an empty stack 
		Stack<Character> stack = new Stack<Character>();
		// Traverse the input string character by character 
		// convert string to character array and traverse each character
		for (char c : s.toCharArray()) {
			// If the character is an openining bracket (I.E., '[','{','(') 
			// Push it into the stack 
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		
		return stack.isEmpty();
	}

}
