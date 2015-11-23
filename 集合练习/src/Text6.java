import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


public class Text6 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner c = new Scanner(System.in);
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) 
			{
				int num = o2.compareTo(o1);
				return num ==0? 1:num;//‘ –Ì÷ÿ∏¥
			}
		});
			while(true)
			{
				String line = c.nextLine();
				if("quit".equals(line))
					break;
				Integer num = Integer.parseInt(line);
				ts.add(num);
			}
			for (Integer i : ts) 
			{
				System.out.println(i);
			}
		}

}
