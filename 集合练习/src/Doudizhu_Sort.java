import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;


public class Doudizhu_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color = {"����","����","����","÷��"};
		HashMap<Integer, String> hm = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		int Inder =0;
		for (String Num : num) {
			for (String Color : color) {
				hm.put(Inder, Color.concat(Num));
				list.add(Inder);
				Inder++;
			}
		}
		hm.put(Inder, "С��");
		list.add(Inder);
		Inder++;
		hm.put(Inder, "����");
		list.add(Inder);
		//System.out.println(list);
		Collections.shuffle(list);
		//System.out.println(list);
		TreeSet<Integer> Player1 = new TreeSet<>();
		TreeSet<Integer> Player2 = new TreeSet<>();
		TreeSet<Integer> Player3 = new TreeSet<>();
		TreeSet<Integer> Dipai = new TreeSet<>();
		for(int i=0;i<list.size();i++)
		{
			if(i>=list.size()-3)
			{
				Dipai.add(list.get(i));
			}
			else if(i%3==0)
			{
				Player1.add(list.get(i));
			}
			else if(i%3==1)
			{
				Player2.add(list.get(i));
			}
			else
			{
				Player3.add(list.get(i));
			}
		}
		//����
		LookPoker(hm, Player1, "Player1");
		LookPoker(hm, Player2, "Player2");
		LookPoker(hm, Player3, "Player3");
		LookPoker(hm, Dipai, "����");
		
	}
	//
	//
public static void LookPoker(HashMap<Integer, String>hm,TreeSet<Integer> ts,String name)
	{
		System.out.println(name+"������:");
		for(Integer i : ts)
		{
			System.out.print(hm.get(i)+" ");
		}
		System.out.println("");
	}
}
