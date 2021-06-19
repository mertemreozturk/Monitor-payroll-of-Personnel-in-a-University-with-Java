

public class FullTime extends Employee {

	public FullTime(String name, String registerNumber, String position, int yearOfStart, double salary, int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
		
	}
	public void dayOfWork(int pay) {
		this.salary += pay*5*4;  // pay x day x week
	}
}
