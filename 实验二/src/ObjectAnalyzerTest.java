import java.util.ArrayList;


public class ObjectAnalyzerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ArrayList<Employee> squqres = new ArrayList<>();
		for(int i=1;i<=5;i++)
			squqres.add(new Employee("ÕÅÈý","001", (double)i*1000));
		System.out.println(new ObjectAnalyzer().toString(squqres));
	}

}
