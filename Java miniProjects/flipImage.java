/*
 *  Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image/
 *	To flip an image horizontally means that each row is reverses [1,1,0] -> [0,1,1]
 *	
 *	To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0,1,1] -> [1,0,0]
 *
 *	ex.	Input  [[1,1,0],[1,0,1],[0,0,0]]
 *		Output [[1,0,0],[0,1,0],[1,1,1]]
 */


public class flipImage {
	public static void main (String[] args) 
	{
		int arr[][] = {{1,1,0},
						{1,0,1},
						{0,0,0}};
		
		int A [][] = flipAndInvertImage(arr);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] flipAndInvertImage(int[][] A) 
	{
		int z = A.length-1;
		int temp;
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length && j < z; j++) {	
				temp = A[i][j];
				A[i][j] = A[i][z];
				A[i][z] = temp;
				z--;
				
			}
			for (int n = 0; n < A.length; n++) {
				if (A[i][n] == 0) { A[i][n] = 1; }
				else if (A[i][n] == 1) { A[i][n] = 0; }
			}
			z= A.length-1;
		}	
		return A;	
	}
}

