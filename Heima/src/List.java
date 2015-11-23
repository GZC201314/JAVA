import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;




public class List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("AAA");
		list.add("AAA");
		list.add("AAA");
		list.add("BBB");
		list.add("AAA");
		list.add("CCC");
		list.add("LIST");
		list.add("ARRAY");
		list.add("AAA");
		sort(list);//ctrl+1
		System.out.println(list);
	}

	private static void sort(ArrayList<String> list) {
		//创建treeset集合对象
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int num = s1.compareTo(s2);
				return num==0?1:num;
			}
			
		});
		ts.addAll(list);
		list.clear();
		list.addAll(ts);
	
	}


}
