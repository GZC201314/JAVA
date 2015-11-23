import java.util.ArrayList;
import java.util.Collections;


public class Collections_text {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("f");
		list.add("e");
		list.add("d");
		Collections.binarySearch(list, "a");
		System.out.println(Collections.binarySearch(list, "f"));
		System.out.println(Collections.max(list));
		Collections.reverse(list);
		System.out.println(list);
	}

}
