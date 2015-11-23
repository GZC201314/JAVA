import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


public class Text7 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生成绩格式是:姓名,语文成绩,数学成绩,英语成绩");
		TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() 
				{

			@Override
			public int compare(Student o1, Student o2) 
			{
				int num = (int)( o2.getSum()-o1.getSum());
				return num==0 ? 1:num;
			}
		});
		while(ts.size()!=5)
		{
			try
			{
							String line = sc.nextLine();
			String[] arr = line.split(",");
			Student Stu = new Student();
			Stu.setName(arr[0]);
			Stu.setChinese(Float.parseFloat(arr[1]));
			Stu.setMath(Float.parseFloat(arr[2]));
			Stu.setEnglish(Float.parseFloat(arr[3]));
			Stu.setSum(Float.parseFloat(arr[1])+Float.parseFloat(arr[2])+Float.parseFloat(arr[3]));
			ts.add(Stu);
			}
			catch(Exception e)
			{
				System.out.println("异常抛出!!!");
				System.out.println(e.getMessage());
			}
			

		}
		for (Student stu : ts) 
		{
			System.out.println(stu);
		}
			
	}

}
