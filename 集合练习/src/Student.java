
public class Student 
{
	private String Name;
	private float Chinese;
	private float Math;
	private float English;
	private float Sum;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getChinese() {
		return Chinese;
	}
	public void setChinese(float chinese) {
		Chinese = chinese;
	}
	public float getMath() {
		return Math;
	}
	public void setMath(float math) {
		Math = math;
	}
	public float getEnglish() {
		return English;
	}
	public void setEnglish(float english) {
		English = english;
	}
	public float getSum() {
		return Sum;
	}
	public void setSum(float sum) {
		Sum = sum;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, float chinese, float math, float english
			) {
		super();
		Name = name;
		Chinese = chinese;
		Math = math;
		English = english;
		Sum =chinese+math+english;
		//Sum = sum;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Chinese=" + Chinese + ", Math="
				+ Math + ", English=" + English + ", Sum=" + Sum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(Chinese);
		result = prime * result + Float.floatToIntBits(English);
		result = prime * result + Float.floatToIntBits(Math);
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Float.floatToIntBits(Chinese+Math+English);
		System.out.println("hashCodeº¯ÊýÖ´ÐÐÁË");
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Float.floatToIntBits(Chinese) != Float
				.floatToIntBits(other.Chinese))
			return false;
		if (Float.floatToIntBits(English) != Float
				.floatToIntBits(other.English))
			return false;
		if (Float.floatToIntBits(Math) != Float.floatToIntBits(other.Math))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Float.floatToIntBits(Sum) != Float.floatToIntBits(other.Sum))
			return false;
		return true;
//		Student st = (Student)obj;
//		if(st.getSum()==this.getSum()&&st.getName().equals(this.getName()))
//			return true;
//		else
//			return false;
		//if()
	}
	
	
}
