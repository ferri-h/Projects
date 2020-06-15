import java.util.List;
/*
 * Given a matrix m x n elements, return all elements of the matrix in spiral order
 * 
 * example
 * input:
 *	[1 2 3]
 *	[4 5 6]
 *	[7 8 9]
 *
 * output
 * [1,2,3,6,9,8,7,4,5]
 *
 */
public class spiralMatrix {
	public static void main (String [] args) {
		int [][] matrix = {
							{1, 2,  3,  4},
							{5,	6,  7,  8},
							{9, 10, 11, 12}
								};
		List<Integer> solution = spiralOrder(matrix);
		
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
        return null;
    }
}
