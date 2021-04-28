import java.io.Serializable;

public class Account implements Serializable{
	
	private String fName;
	private String lName;
	private int rNumber;
	private String eRaider;
	private String password;
	private boolean isStaff;
	private String email;
	private String permit;
	
	public Account(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	
	public void setFName(String fname) {
		this.fName = fname;
	}
	
	public String getFName() {
		return this.fName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public String getLName() {
		return this.lName;
	}
	
	public void setrNumber(int rNum) {
		this.rNumber = rNum;
	}
	
	public int getrNum() {
		return this.rNumber;
	}
	
	public void seteRaider(String eRaid) {
		this.eRaider = eRaid;
	}
	
	public String geteRaider() {
		return this.eRaider;
	}
	
	public void setPWord(String pwd) {
		this.password = pwd;
	}
	
	public boolean checkPassword(String word) {
		return this.password == word;
	}
	
	public void setStaff(boolean isStudent) {
		this.isStaff = !isStudent;
	}
	
	public boolean isStudent() {
		return !this.isStaff;
	}
	
	public void setEmail(String e) {
		this.email = e;
	}
	
	public void setPermit(String p) {
		this.permit = p;
	}
	
	public String getPermit() {
		return this.permit;
	}
	
}



