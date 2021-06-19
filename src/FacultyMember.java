

public class FacultyMember extends Academician{

	public FacultyMember(String name, String registerNumber, String position, int yearOfStart, double salary,
			int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
	}
	public void addCourseFee(int hours) {  // faculty member can get additional course fees up to 8 hours per week and for each working hour they are paid 20 TL  
		if ( hours >40 ) {    
			int acf = hours - 40;
			if ( acf <= 8) {
				this.salary += acf*20.00;
			}
			else {  // if they teach more than 8 hours in a week, they will be paid only for 8 hours
				this.salary += 8*20.00;
			}
		}
	}

}
