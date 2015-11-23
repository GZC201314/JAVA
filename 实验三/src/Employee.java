
public class Employee 
{
	protected String name;
	protected String no;
	protected double Salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalas(double salary) {
		this.Salary = salary;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (Double.doubleToLongBits(Salary) != Double
				.doubleToLongBits(other.Salary))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", no=" + no + ", salas=" + Salary
				+ "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String no, double salas) {
		super();
		this.name = name;
		this.no = no;
		this.Salary = salas;
	}
	
}
