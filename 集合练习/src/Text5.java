import java.util.Comparator;
import java.util.TreeMap;


public class Text5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				System.out.println("ִ������?");
				int num = (int)(o2.getSum()-o1.getSum());
				System.out.println(num);
				return num==0 ? o1.getName().compareTo(o2.getName()):num;
			}
		});
		//tm.
		tm.put(new Student("����", 90, 90, 90), "����");
		tm.put(new Student("����", 100, 100, 90), "�Ϻ�");
		tm.put(new Student("����", 100, 100, 100), "�Ϻ�");
		tm.put(new Student("����", 100, 100, 100), "�Ϻ�");
		System.out.println(tm);
	}

}
