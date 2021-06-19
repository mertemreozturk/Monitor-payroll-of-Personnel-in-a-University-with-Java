
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	
	public void write(Personnel[] personnelObj) {
		try {
		      for (int i = 0; i < personnelObj.length; i++) {
		    	  FileWriter fWriter = new FileWriter(personnelObj[i].getRegisterNumber() + ".txt");
			      BufferedWriter writer = new BufferedWriter(fWriter);
			      String[] name = personnelObj[i].getName().split(" ");
			      writer.write("Name : " + name[0] + "\n" + "Surname : " + name[1] + "\n" + "Registration Number : " + personnelObj[i].getRegisterNumber() +
			    		  "\n" + "Position : " + personnelObj[i].getPosition() + "\n" + "Year of Start : " + personnelObj[i].getYearOfStart() + "\n" +
			    		  "Total Salary : " + (personnelObj[i].toString(personnelObj[i].getSalary())) + " TL");
			      writer.close();
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
}