package model;

public class Seller extends User{
	

	private Shop shop;

	public Seller(String username, String password, String shopName, String shopType, String shopDescription) {
		super(username, password);
		this.shop = new Shop(this, shopName, shopType, shopDescription);
	}
	public Seller(String username, String password, Shop shop) {
		super(username, password);
		this.shop =shop;
	}
	public Seller(String username, String password) {
		super(username, password);
	}
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	
}
