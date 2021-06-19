
public class Officer extends Personnel{

	public Officer(String name, String registerNumber, String position, int yearOfStart, double salary, int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
	}
	
	public void baseSalary() {
		this.salary += 2600;
	}
	public void ssBenefits(double percent) {
		this.salary += 2600*percent;  
	}
	public void overWorkSalary(int hours) {  // officer can work up to 10 hours a week and for each working hour, they are paid 20 TL
		if ( hours >40 ) {
			int ows = hours - 40;
			if ( ows <= 10) {
				this.salary += ows*20.00;
			}
			else {  // if they work more than 10 hours a week, they are paid up to 10 hours
				this.salary += 10*20.00;
			}
		}
	}	
}
