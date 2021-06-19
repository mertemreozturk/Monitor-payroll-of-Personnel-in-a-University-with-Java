
public class Security extends Personnel{

	public Security(String name, String registerNumber, String position, int yearOfStart, double salary, int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
	}
	
	public void hourOfWork(int hours) { // Security can work a maximum of 9 hours and a minimum of 5 hours a day
		if ( 30 <= hours ) {  // six day x five hours
			this.salary += 6*(10 + 5);   // six day x (food money(10) + transportation money(5))
			if ( hours <= 54) {    // six day x nine hours
				this.salary += hours*10.00;  // For each working hour, they are paid 10 TL
			} else {  
				this.salary += 54*10.00;  // if they work more than 54 hours a week, they are paid up to 54 hours
			}	 
		}
	}
}
