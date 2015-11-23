import java.lang.reflect.*;


public class Text3 {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		//Method square = Text3.class.getMethod("square", double.class);
		Method square = Text3.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		Employee e1 = new Employee("郭志超", "001", 8000);
		Method getSalary = e1.getClass().getMethod("getSalary");
		//Manager m1 = new Manager("郭志超","002",5000);
		Manger m1 = new Manger("郭志超", "002", 10000);
		//Method setSdept = m1.getClass().getMethod("setSdept");
		Method m_getSalary = m1.getClass().getMethod("getSalary");
		System.out.println(square);
		System.out.println(square.invoke(null, 3.0));
		System.out.println(sqrt);
		System.out.println(sqrt.invoke(null, 9.0));
		System.out.println(getSalary);
		System.out.println(getSalary.invoke(e1));
		//System.out.println(setSdept);
		//System.out.println(m1,"数理学院");
		//setSdept.invoke(m1, "数理学院");
		System.out.println(m_getSalary);
		System.out.println(m_getSalary.invoke(m1));
	}
	public static double square(double x)
	{
		return x*x;
	}
}
