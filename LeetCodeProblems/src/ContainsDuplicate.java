import java.util.HashSet;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   

	    int[] nums1 = {1, 2, 3, 4};
	    System.out.println(containsDuplicate(nums1)); // Expected output: false

	    int[] nums2 = {1, 2, 3, 1};
	    System.out.println(containsDuplicate(nums2)); // Expected output: true

	    int[] nums3 = {};
	    System.out.println(containsDuplicate(nums3)); // Expected output: false

	    int[] nums4 = {1, 1, 1, 1};
	    System.out.println(containsDuplicate(nums4)); // Expected output: true
	    

	}
	
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> unique_set = new HashSet<Integer>();
		for(int i : nums) {
			if(!unique_set.add(i)) {
				return true;
			}
		}
		return false;
	}

}
