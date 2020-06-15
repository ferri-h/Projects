/*
 * Given an array of integers target, From a starting array, A consisting of all 1's, 
 * you may perform the following procedure:
 * 
 * - Let x be the sum of all elements in array
 * - Choose index i such that 0 <= i < target.size and set value of A at index i to x
 * - Ypu may repeat procedure as many times as needed
 * 
 * Return True if possible to construct target from A otherwise return false
 * 
 * Ex 
 * Target -> [9,3,5]
 * Start ->	 [1,1,1] 	sum = 3, choose i = 1
 * 			 [1,3,1]	sum = 5, choose i = 2
 * 			 [1,3,5] 	sum = 9, choose i = 0
 * 			 [9,3,5]	got target, return true
 * 
 */


public class targetArray {
	public static void main(String[] args) {
		int[] a = {9,3,5};
		//int[] a = {1,1,1,2};
		
		// MORE TEST CASES, uncomment and test with 'isPossible' method
		/*
		int[] a = {4,1,3,7};
		int[] a = {3,1,5,9};
		int[] a = {7,8,9,3};
		int[] a = {3,3,5};
		int[] a = {1,3,5,4,8,3};
		int[] a = {9,1,1,5,9,1,2,3,7};
		*/
		
		System.out.println(isPossible(a));
	}
	
	public static boolean isPossible(int[] target) {
		int[] ones = new int[target.length];
		for (int i = 0; i < target.length; i++) {ones[i] = 1;}; // populate with 1;s
	
		int sum = 0;
		
		
		while (true) {
			for (int i = 0; i < ones.length; i++) { sum += ones[i]; };
			//System.out.println("Sum: " +  sum);
			
			for (int i = 0; i < target.length; i++) { 
				if (target[i] == sum) {
					ones[i] = sum;
				}
			}

			boolean check = true;
			for (int i = 0; i < target.length; i++) { 
				if (target[i] != ones[i]) { check = false; }
			}
			
			if (check == true) { return true; }
			
			// if sum not in target array
			boolean check2 = false;
			for (int i = 0; i < target.length; i++) { 
				if (target[i] == sum) {check2 = true; }
			}
			if (check2 == false) { return false; }
			
			sum = 0;
		
			// sum cannot be larger than target sum
			
		}
	}
}
