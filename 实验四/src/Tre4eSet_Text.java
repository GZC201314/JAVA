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
				//���ݷ���ֵ�Ĳ�ͬ���Կ��ƴ洢��Ψһ��,���������0,�Ϳ��Ա�֤Ԫ�ص�Ψһ��
				//ͨ����������
//				int num = o1.getName().compareTo(o2.getName());
//				num = num + o1.getAge()-o1.getAge();
//				//num = num + o1.getY_birther()
//				//return num;      //����Ԫ��Ψһ
//				return num==0? 1:num; //����Ԫ�ز�Ψһ
				
				
				
				
				//ͨ����������
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
		ts.add(new Item("��־��", 22, 1994));
		ts.add(new Item("��־��", 22, 1994));
		for (Item it : ts) 
		{
			System.out.println(it);
		}
	}
	

}
