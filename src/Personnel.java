
public class Personnel {
	protected String name;
	protected String registerNumber;
	protected String position;
	protected int yearOfStart;
	protected double salary;
	protected int[] hours;
	
	public Personnel(String name, String registerNumber, String position, int yearOfStart, double salary, int[] hours) {
		this.name = name;
		this.registerNumber = registerNumber;
		this.position = position;
		this.yearOfStart = yearOfStart;
		this.salary = salary;
		this.hours = hours;
	}
	public String toString(double salary) {    // salary should be .00 TL
		return Double.toString(salary)+"0";
	}
	public void severancePay(int year) {     // severance pay for each personnel
		this.salary += (2020 - year)*20*0.8;
	}	
	// getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYearOfStart() {
		return yearOfStart;
	}

	public void setYearOfStart(int yearOfStart) {
		this.yearOfStart = yearOfStart;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int[] getHours() {
		return hours;
	}
	public void setHours(int[] hours) {
		this.hours = hours;
	}
}
