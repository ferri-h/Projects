
public class JewelsInStones {
	/*
	 * Given string J, representing the types of stones that are jewels, and S representing the
	 * stones you have. Each character is a type of stone you have. You want to know how many of 
	 * the stones you have are also jewels
	 * 
	 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters
	 * are case sensitive, so "a" is considered a different type of stone from "A"
	 */
	
	public static void main(String[] args)
	{
		int retval = numJewelsInSTones("aA","aAAbbbb");
		System.out.println(retval);
	}
	
	public static int numJewelsInSTones(String J, String S)
	{
		int jewels = 0;
		
		for (int i = 0; i < J.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (J.charAt(i) == S.charAt(j)) {
					jewels++;
				}
			}
		}
		return jewels;
	}
}
