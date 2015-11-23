import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Map_Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//demo1();
		Map<String, Integer> map = new TreeMap<>();
		map.put("����", 23);
		//map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
		map.put("����", 27);
		map.put("����", 24);
		for (String string : map.keySet()) 
		{
			System.out.println(string+"="+map.get(string));
		}
	}

	private static void demo1() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("����", 23);
		map.put("����	", 24);
		map.put("����", 25);
		map.put("����", 26);
		map.put("����", 27);
		Set<String> arr = map.keySet();
		Iterator<String> it = arr.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"="+value);
		}
	}

}
