import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Map_Entry 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Map<String, Integer> map = new TreeMap<>();
		map.put("张三", 23);
		//map.put("李四", 24);
		map.put("王五", 25);
		map.put("赵六", 26);
		map.put("周七", 27);
		map.put("李四", 24);
		Set<Map.Entry<String,Integer>> entryset = map.entrySet();
		//Iterator<Map.Entry<String, Integer>> it = entryset.iterator();
//		while(it.hasNext())
//		{
//			Map.Entry<String, Integer> en = it.next();
//			String key = en.getKey();
//			Integer value = en.getValue();
//			System.out.println(key+"="+value);
//		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}

}
//interface Inter{
//	interface Inter{
//		public void show();
//	}
//}
//class Demo impla