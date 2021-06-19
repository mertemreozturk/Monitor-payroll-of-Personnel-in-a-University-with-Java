

public class Chief extends FullTime {

	public Chief(String name, String registerNumber, String position, int yearOfStart, double salary, int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
		
	}
	public void overWorkSalary(int hours) {
		int ows = hours - 40;
		if (hours <= 48) {  // Chiefs can work a maximum of 8 hours a week and are paid 15 TL per hour to gain overwork salary
			this.salary += ows*15.00;
		}
		else {
			this.salary += 8*15.00; // if they work more than 48 hours a day, they are paid up to 8 hours
		}
	}
}
