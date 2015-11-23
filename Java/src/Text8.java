import java.util.HashMap;
import java.util.Scanner;


public class Text8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("ÇëÊäÈë×Ö·û´®:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (char c : arr) 
		{
//			if(!hm.containsKey(c))
//			{
//				hm.put(c, 1);
//			}
//			else
//			{
//				hm.put(c, hm.get(c)+1);
//			}
			hm.put(c, hm.containsKey(c)? hm.get(c)+1:1);
		}
		//System.out.println(hm);
		for (Character c : hm.keySet()) 
		{
			System.out.println(c +"="+hm.get(c));
		}
	}

}
