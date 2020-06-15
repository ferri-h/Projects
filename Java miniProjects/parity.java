/*
 * Given an array A of non-negative integers, return an array consisting of all the even 
 * elements of A, followed by all the odd elements of A.
 * 
 * Input:
 * [3, 1, 2, 4]
 * Output:
 * [2, 4, 3 ,1] , [4, 2, 3, 1] ...
 * 
 */


public class parity {
	public static void main (String[] args) {
		int [] A = {3,1,2,4};
		int [] get = sortArrayByParity(A);
		for (int i = 0; i < get.length; i++) { System.out.print(get[i] + " "); }
		System.out.println();
		
	}
	
	public static int[] sortArrayByParity(int[] A) {
		int [] solution = new int[A.length];
		
		int z = 0;
		for (int i = 0; i < A.length; i++){
			if (A[i] % 2 == 0) { // even
				solution[z] = A[i];
				z++;
			}
		}
		
		for (int i = 0; i < A.length; i++){
			if (A[i] % 2 == 1) { // odd
				solution[z] = A[i];
				z++;
			}
		}
		
		return solution;
	}
}
