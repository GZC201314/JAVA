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
				System.out.println("执行了吗?");
				int num = (int)(o2.getSum()-o1.getSum());
				System.out.println(num);
				return num==0 ? o1.getName().compareTo(o2.getName()):num;
			}
		});
		//tm.
		tm.put(new Student("张三", 90, 90, 90), "北京");
		tm.put(new Student("李四", 100, 100, 90), "上海");
		tm.put(new Student("周期", 100, 100, 100), "上海");
		tm.put(new Student("王五", 100, 100, 100), "上海");
		System.out.println(tm);
	}

}
