import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import java.lang.reflect.Method;


public class Text1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name;
		if(args.length>0)
			name = args[0];
		else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Date): ");
			name = in.next();
			in.close();
		}
		try
		{
			Class c1 = Class.forName(name);
			Class superc1 = c1.getSuperclass();
			System.out.print("class " + superc1.getName());
			if(superc1 != null && superc1 !=Object.class)
				System.out.print("extends "+ superc1.getClass());
			System.out.print("\n{\n");
			printConstructors(c1);
			System.out.println();
			printMethods(c1);
			System.out.println();
			System.out.println("}");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.exit(0);
	}re==

	private static void printMethods(Class c1) 
	{
		Method[] methods = c1.getDeclaredMethods();
		for(java.lang.reflect.Method m : methods)
		{
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print("   " + Modifier.toString(m.getModifiers()));
			System.out.print(" "+ retType.getName()+" "+name+"(");
			Class[] paramTypes = m.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) 
			{
				if(i>0)
					System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}

	private static void printConstructors(Class c1) 
	{
		Constructor[] constructors = c1.getDeclaredConstructors();
		for (Constructor c : constructors) 
		{
			String name = c.getName();
			System.out.print("   "+Modifier.toString(c.getModifiers()));
			System.out.print(" "+name+"(");
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) 
			{
				if(j>0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
		
		
	}

}
