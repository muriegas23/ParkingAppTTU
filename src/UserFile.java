import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class UserFile {
		
	public String signinUser() {
		FileReader in = null;
		try {
			in = new FileReader("users.txt");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void createUser() {
		FileWriter out = null;
		
	}
	
}
