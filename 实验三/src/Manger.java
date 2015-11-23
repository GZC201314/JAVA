
public class Manger extends Employee
{
	private String Sdept;

	public String getSdept() {
		return Sdept;
	}

	public void setSdept(String sdept) {
		Sdept = sdept;
	}

	public Manger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manger(String name, String no, double salaay) {
		super(name, no, salaay);
		// TODO Auto-generated constructor stub
	}
	

	public Manger(String sdept) {
		super();
		Sdept = sdept;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Sdept == null) ? 0 : Sdept.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manger other = (Manger) obj;
		if (Sdept == null) {
			if (other.Sdept != null)
				return false;
		} else if (!Sdept.equals(other.Sdept))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manger [Sdept=" + Sdept + ", name=" + name + ", no=" + no
				+ ", Salary=" + Salary + "]";
	}
	
	
}
