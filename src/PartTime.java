

public class PartTime extends Employee{

	public PartTime(String name, String registerNumber, String position, int yearOfStart, double salary, int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
		
	}
	public void hourOfWork(int hours) {  // Part-time Employees can work a minimum of 10 hours and a maximum of 20 hours a week and they are paid 18 TL per hour
		if ( 10 <= hours) {
			if ( hours <= 20) {
				this.salary += hours*18.00;
			}
			else {
				this.salary += 20*18.00;
			}
		}
	}

}
