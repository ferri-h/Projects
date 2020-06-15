
public class numofsteps {
	/*
	 * Given a non-negative integer "num", return the number of steps to reduce it to zero. 
	 * If the current number is even, you have to subtract 1 from it
	 */
	
	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));
	}
	
	public static int numberOfSteps(int num) {
		int count = 0;
		
		while (num != 0) {
			if (num % 2 == 0) { // if even
				num /= 2;
				count++;
			} else {
				num -= 1;
				count++;
			}
		}
		return count;
	}
}
