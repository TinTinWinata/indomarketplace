package model;

public class Customer extends User{
	
	private String gender;

	public Customer(String username, String password, String gender) {
		super(username, password);
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
