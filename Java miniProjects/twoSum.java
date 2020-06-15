
public class twoSum {
	/*
	 * Given an array of integers, return indices of the two numbers such 
	 * that they add up to a specific target
	 * 
	 * Given nums = [2, 7, 11, 15],
	 * target = 9;
	 * 
	 * Because nums[0] + nums[1] = 2+7 = 9, return [0,1]
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int [] nums = new int[]{3,2,4};;
		int[] solution; 
		
		solution = twosum(nums,6);
		for (int i = 0; i<solution.length;i++) {
			System.out.print(solution[i] + " ");
		}
		
	}
	
	
	public static int[] twosum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) 
		{
			for (int j = 0; j < nums.length; j++) 
			{
				if (nums[i] + nums[j] == target && i != j ) 
				{	
					return new int[] {j,i};
				}
			}
		}
		return null;
		//return nums;
	}
}
