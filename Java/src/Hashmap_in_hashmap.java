import java.util.HashMap;


public class Hashmap_in_hashmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Student, String> hm88 = new HashMap<>();
		hm88.put(new Student("����", 23), "����");
		hm88.put(new Student("����", 24), "��ɽ");
		hm88.put(new Student("����", 25), "�Ͼ�");

		HashMap<Student, String> hm99 = new HashMap<>();
		hm99.put(new Student("����", 26), "�Ϸ�");
		hm99.put(new Student("����", 27), "�ߺ�");
		hm99.put(new Student("Ǯ��", 28), "����");
		HashMap<HashMap<Student, String>, String> hm = new HashMap<>();
		hm.put(hm88, "�����Ҿ�ס�ĵط�");
		hm.put(hm99, "������ȥ���ĵط�");
		for(HashMap<Student, String> h:hm.keySet())
		{
			String address= hm.get(h);
			for(Student st: h.keySet())
			{
				String Address = h.get(st);
				System.out.println(st+"ס��"+Address+" "+address);
			}
		}
	}

}
