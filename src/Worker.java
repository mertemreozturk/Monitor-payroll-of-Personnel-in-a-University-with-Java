

public class Worker extends FullTime{

	public Worker(String name, String registerNumber, String position, int yearOfStart, double salary, int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
	}
	
	public void overWorkSalary(int hours) {
		int ows = hours - 40;
		if (hours <= 50) {  // Workers can work a maximum of 10 hours a week and are paid 11 TL per hour
				this.salary += ows*11.00;
		}else {
			this.salary += 10.00*11.00;
		}
	}
}
