import java.util.ArrayList;
import java.util.List;

public class FindAllDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    List<Integer> duplicates = FindAllDups.findNumbers(new int[] { 3, 4, 4, 5, 5 });
	    System.out.println("Duplicates are: " + duplicates);

	    duplicates = FindAllDups.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
	    System.out.println("Duplicates are: " + duplicates);
	}
	  public static List<Integer> findNumbers(int[] nums) {
		    List<Integer> duplicateNumbers = new ArrayList<>();
		    // TODO: Write your code here
		      int i = 0;

		      while (i < nums.length) {
		        // Note the range is 1 - n;
		        int currentPos = nums[i] - 1;
		        if (nums[i] != nums[currentPos]) {
		          swap(nums, i, currentPos);
		        } else {
		          i++;
		        }
		      }

		      for (i = 0; i < nums.length; i++) {
		        if (nums[i] != i + 1) {
		          duplicateNumbers.add(nums[i]);
		        }
		      }

		    return duplicateNumbers;
		  }

	  public static void swap (int[] nums, int i, int currentPos) {
	    int temp = nums[i];
	    nums[i] = nums[currentPos];
	    nums[currentPos] = temp;
	  }
}
