import java.util.ArrayList;
import java.util.Collections;


public class Text_doudizhu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建对象
		String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] colar = {"红桃","黑桃","方块","梅花"};
		ArrayList<String> Card = new ArrayList<>();
		for (String Colar : colar) 
		{
			for (String Num : num) 
			{
				Card.add(Colar.concat(Num));
			}
		}
		Card.add("小王");
		Card.add("大王");
		//洗牌
		Collections.shuffle(Card);
		//创建玩家对象
		ArrayList<String> Player1 = new ArrayList<>();
		ArrayList<String> Player2 = new ArrayList<>();
		ArrayList<String> Player3 = new ArrayList<>();
		ArrayList<String> Dipai = new ArrayList<>();
		//发牌
		for(int i=0; i<Card.size();i++)
		{
			if(i>=Card.size()-3)
			{
				Dipai.add(Card.get(i));
			}
			else if(i%3==0)
			{
				Player1.add(Card.get(i));
			}
			else if(i%3==1)
			{
				Player2.add(Card.get(i));
			}
			else
			{
				Player3.add(Card.get(i));
			}
		}
		System.out.println(Player1);
		System.out.println(Player2);
		System.out.println(Player3);
		System.out.println(Dipai);
	}

}
