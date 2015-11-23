import java.util.Comparator;
import java.util.TreeSet;


public class Tre4eSet_Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		TreeSet<Item> ts = new TreeSet<>(new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) 
			{
				//根据返回值的不同可以控制存储的唯一性,如果允许返回0,就可以保证元素的唯一性
				//通过姓名排序
//				int num = o1.getName().compareTo(o2.getName());
//				num = num + o1.getAge()-o1.getAge();
//				//num = num + o1.getY_birther()
//				//return num;      //插入元素唯一
//				return num==0? 1:num; //插入元素不唯一
				
				
				
				
				//通过年龄排序
				int num = o1.getAge()-o2.getAge();
				return num;
			}
			
		});
		ts.add(new Item("Amy", 23, 1994));
		ts.add(new Item("Carl", 24, 1994));
		ts.add(new Item("Bob", 29, 1994));
		ts.add(new Item("Dug", 22, 1994));
		ts.add(new Item("Elise", 20, 1994));
		ts.add(new Item("Amy", 22, 1994));
		ts.add(new Item("Amy", 22, 1994));
		ts.add(new Item("Amy", 22, 1994));
		ts.add(new Item("郭志超", 22, 1994));
		ts.add(new Item("郭志超", 22, 1994));
		for (Item it : ts) 
		{
			System.out.println(it);
		}
	}
	

}
