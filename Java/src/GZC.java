import java.util.HashSet;


public class GZC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Person> hs= new HashSet<>();
		hs.add(new Person("����",23));
		hs.add(new Person("����",23));
		hs.add(new Person("����",23));
		hs.add(new Person("����",24));
		hs.add(new Person("����",24));
		hs.add(new Person("����",25));
		System.out.println(hs);
		
		
		
	}

}
