import java.util.HashMap;
import java.util.Hashtable;


public class HashTable_text {

	/**
	 * @param args
	 * HashMap和Hashtable的区别
	 * HashMap是现成不安全的,效率高
	 * Hashtable 是线程安全的,效率低
	 * HashMap可以存储null
	 * Hashtable不可以存储null
	 */
	public static void main(String[] args) {
//		HashMap<String, Integer> hm = new HashMap<>();
//		hm.put(null, null);
//		System.out.println(hm);
		Hashtable<String, Integer> ht =new Hashtable<>();
		ht.put(null, null);
		System.out.println(ht);
	}

}
