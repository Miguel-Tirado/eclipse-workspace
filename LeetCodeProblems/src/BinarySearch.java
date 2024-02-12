
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,7,12,14,23};
		int target = 21;
		
		System.out.println(search(nums,target));

	}
	
	public static int search(int[] nums, int target) {
		// Declare variables
		int start = 0;
		int end = nums.length-1;
		
		//Iterative loop to check 
		while (start <= end) {
			// gets the middle position
			// gets the middle value
			int midPos = (start + end)/2;
			int midVal = nums[midPos];
			
			if (target == midVal) {
				return midPos;
			} else if (target < midVal) {  // Looking at the left of the array
				end = midPos -1;
			} else {
				start = midPos + 1;
			}
			
		}
		// Target value could be found return -1
		return -1;
		
	}

}
