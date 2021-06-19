
public class Controller {
	private FacultyMember[] facultyMember;   // define object
	private ResearchAssistant[] researchAssistant;
	private PartTime[] partTime;
	private Worker[] worker;
	private Chief[] chief;
	private Officer[] officer;
	private Security[] security;
	private String[] textOne;
	private String[] textTwo;
	
	WriteToFile writer = new WriteToFile();    // create writer object
	
	public Controller(String dataOne, String dataTwo) {
		ReadFromFile file = new ReadFromFile();
		this.textOne = file.readFile(dataOne);    // personnel.txt
		this.textTwo = file.readFile(dataTwo);    // monitoring.txt
		
		this.facultyMember = new FacultyMember[lengthOfArray("FACULTY_MEMBER", textOne)];    // define length of array
		this.security = new Security[lengthOfArray("SECURITY", textOne)];
		this.officer = new Officer[lengthOfArray("OFFICER", textOne)];
		this.worker = new Worker[lengthOfArray("WORKER", textOne)];
		this.researchAssistant = new ResearchAssistant[lengthOfArray("RESEARCH_ASSISTANT", textOne)];
		this.chief = new Chief[lengthOfArray("CHIEF", textOne)];
		this.partTime = new PartTime[lengthOfArray("PARTTIME_EMPLOYEE", textOne)];
		
	}
	public void control() {
		int o = 0, f = 0, r = 0, c = 0, w = 0, p = 0, s = 0;     // number of each position
		for(String line:textOne) { 
			String[] x = line.split("\t");
			int year = Integer.parseInt(x[3]);
			if ( x[2].equals("OFFICER")) {     // find position
				int[] officerHours = monitor(textTwo, x[1]);     // array of four week for work hours 
				officer[o] = new Officer(x[0], x[1], x[2], year, 0.00, officerHours);   // create object
				officer[o].severancePay(year);
				officer[o].baseSalary();
				officer[o].ssBenefits(0.65);
				for ( int i = 0; i < 4; i++) {     // add money to salary for each iteration 
					officer[o].overWorkSalary(officerHours[i]);
				}
				o++;  // next personnel for same position
			}
			else if(x[2].equals("FACULTY_MEMBER")) {
				int[] fMemberHours = monitor(textTwo, x[1]);
				facultyMember[f] = new FacultyMember(x[0], x[1], x[2], year, 0.00, fMemberHours);
				facultyMember[f].severancePay(year);
				facultyMember[f].baseSalary();
				facultyMember[f].ssBenefits(1.35);
				for ( int i = 0; i < 4; i++) {
					facultyMember[f].addCourseFee(fMemberHours[i]);
				}
				f++;
			}
			else if( x[2].equals("RESEARCH_ASSISTANT") ){
				int[] rAssistantHours = monitor(textTwo, x[1]);
				researchAssistant[r] = new ResearchAssistant(x[0], x[1], x[2], year, 0.00, rAssistantHours);
				researchAssistant[r].severancePay(year);
				researchAssistant[r].baseSalary();
				researchAssistant[r].ssBenefits(1.05);
				r++;
			}
			else if( x[2].equals("SECURITY")){
				int[] securityHours = monitor(textTwo, x[1]);
				security[s] = new Security(x[0], x[1], x[2], year, 0.00, securityHours);
				security[s].severancePay(year);
				for (int i = 0; i < 4; i++) {
					security[s].hourOfWork(securityHours[i]);
				}
				s++;
			}
			else if (x[2].equals("WORKER")) {
				int[] workerHours = monitor(textTwo, x[1]);
				worker[w] = new Worker(x[0], x[1], x[2], year, 0.00, workerHours);
				worker[w].severancePay(year);
				worker[w].dayOfWork(105);
				for ( int i = 0; i < 4; i++) {
					worker[w].overWorkSalary(workerHours[i]);
				}
				w++;
			}
			else if (x[2].equals("CHIEF")) {
				int[] chiefHours = monitor(textTwo, x[1]);
				chief[c] = new Chief(x[0], x[1], x[2], year, 0.00, chiefHours);
				chief[c].severancePay(year);
				chief[c].dayOfWork(125);
				for ( int i = 0; i < 4; i++) {
					chief[c].overWorkSalary(chiefHours[i]);
				}
				c++;
			}
			else {
				int[] partTimeHours = monitor(textTwo, x[1]);
				partTime[p] = new PartTime(x[0], x[1], x[2], year, 0.00, partTimeHours);
				partTime[p].severancePay(year);
				for ( int i = 0; i < 4; i++) {
					partTime[p].hourOfWork(partTimeHours[i]);
				}
				p++;
			}
		}
		writePersonnel(officer);   // write to file
		writePersonnel(facultyMember);
		writePersonnel(researchAssistant);
		writePersonnel(security);
		writePersonnel(worker);
		writePersonnel(chief);
		writePersonnel(partTime);
	}
	public int[] monitor(String[] data, String identity) {    // data = monitoring.txt, identity = register number
		int[] hour = new int[4];    // array for four week
		for(String line:data) {
			String[] y = line.split("\t");
			if (y[0].equals(identity)) {    // y[0] = register number
				for(int a=0;a < hour.length;a++) {   
					hour[a] = Integer.parseInt(y[a+1]);
				}
			}	
		}
		return hour;
	}
	public int lengthOfArray(String position, String[] lines) {     // look at monitoring files and find same position after increase count
		int count = 0;
		for (String line:lines) {
			String[] y = line.split("\t");    // split sentences according to tab characters 
			if ( position.equals(y[2]) ) {   // y[2] = position of personnel
				count++;
			}
		}
		return count;
	}
	public void writePersonnel(Personnel[] personnel) {    // 
		if (personnel.length != 0) {    //  if personnel exist in personnel.txt, write to file of her/his
			writer.write(personnel);    // write
		}
	}
}
