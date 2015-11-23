import java.util.HashMap;


public class Hashmap_in_hashmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Student, String> hm88 = new HashMap<>();
		hm88.put(new Student("张三", 23), "亳州");
		hm88.put(new Student("李四", 24), "马鞍山");
		hm88.put(new Student("王五", 25), "南京");

		HashMap<Student, String> hm99 = new HashMap<>();
		hm99.put(new Student("赵六", 26), "合肥");
		hm99.put(new Student("周期", 27), "芜湖");
		hm99.put(new Student("钱八", 28), "贵阳");
		HashMap<HashMap<Student, String>, String> hm = new HashMap<>();
		hm.put(hm88, "这是我居住的地方");
		hm.put(hm99, "这是我去过的地方");
		for(HashMap<Student, String> h:hm.keySet())
		{
			String address= hm.get(h);
			for(Student st: h.keySet())
			{
				String Address = h.get(st);
				System.out.println(st+"住在"+Address+" "+address);
			}
		}
	}

}
