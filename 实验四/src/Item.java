
public class Item 
{
	private String Name;
	private int age;
	private int Y_birther;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getY_birther() {
		return Y_birther;
	}
	public void setY_birther(int y_birther) {
		Y_birther = y_birther;
	}
	public Item(String name, int age, int y_birther) {
		super();
		Name = name;
		this.age = age;
		Y_birther = y_birther;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Y_birther;
		result = prime * result + age;
		return result;

	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Ö´ĞĞÁËÂğ?");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Y_birther != other.Y_birther)
			return false;
		if (age != other.age)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item [Name=" + Name + ", age=" + age + ", Y_birther="
				+ Y_birther + "]";
	}
	
}
