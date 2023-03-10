package model;

public class Shop {

	private User user;
	private String name;
	private String type;
	private String description;
	
	public Shop(User user, String name, String type, String description) {
		super();
		this.user = user;
		this.name = name;
		this.type = type;
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
