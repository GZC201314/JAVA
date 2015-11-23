import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class Text6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÒ»¸ö×Ö·û´®:");
		String str = sc.nextLine();
		char[] ch = str.toCharArray();
		TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				int num = o1.compareTo(o2);
				return num==0? 1:num;
			}

		});
		for (int i = 0; i < ch.length; i++) {
			ts.add(ch[i]);
		}
		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Character character = (Character) iterator.next();
			System.out.print(character);

		}
		
	}

}
