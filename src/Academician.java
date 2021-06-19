
public class Academician extends Personnel{

	public Academician(String name, String registerNumber, String position, int yearOfStart, double salary,
			int[] hours) {
		super(name, registerNumber, position, yearOfStart, salary, hours);
	}
	public void baseSalary() {   
		this.salary += 2600.00;
	}
	public void ssBenefits(double percent) {
		this.salary += 2600.00*percent;
	}
}
