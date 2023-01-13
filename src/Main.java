import java.util.Scanner;
import java.util.Vector;

import model.Customer;
import model.Seller;
import model.Shop;
import model.User;

public class Main {

	Vector<User> userList = new Vector<>();
	Scanner scan = new Scanner(System.in);
	User currentUser = null;
	
	public void seed() {
//		User Seed
		userList.add(new Customer("customer", "customer", "Male"));
		userList.add(new Seller("seller", "seller", "Seller Shop", "Food", "This food is so good"));
	}
	
	public boolean isExist(String username) {
		for (User user : userList) {
			if(user.getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
	
	public void registerCustomer() {
		String name, gender, password;
		while(true){
			System.out.print("Input your username : ");
			name = scan.nextLine();
			if(!name.isEmpty() && !isExist(name)) break;
		};
		do {
			System.out.print("Input your password : ");
			password = scan.nextLine();
		}while(password.isEmpty());
		
		do {
			System.out.print("Input your gender must be 'Male' or 'Female' : ");
			gender = scan.nextLine();
		}while(gender.isEmpty() || !(gender.equals("Male") || gender.equals("Female")));
		
		userList.add(new Customer(name, password, gender));	
		System.out.println("Register Succesfully [press enter]");
		scan.nextLine();
		menu();
	}
	
	public void registerSeller() {
		String name, shopType, password, shopName, shopDescription;
		while(true){
			System.out.print("Input your username : ");
			name = scan.nextLine();
			if(!name.isEmpty() && !isExist(name)) break;
		};
		do {
			System.out.print("Input your password : ");
			password = scan.nextLine();
		}while(password.isEmpty());
		
		do {
			System.out.print("Input your shop name : ");
			shopName= scan.nextLine();
		}while(shopName.isEmpty());
		
		do {
			System.out.print("Input your shop description: ");
			shopDescription = scan.nextLine();
		}while(shopDescription.isEmpty());

		do {
			System.out.print("Input your shop type must be 'Electronic' or 'Fashion' or 'Food And Beverage' : ");
			shopType = scan.nextLine();
		}while(shopType.isEmpty() || !(shopType.equals("Electronic") || shopType.equals("Fashion") || shopType.equals("Food And Beverage")));
		
		userList.add(new Seller(name, password, shopName, shopType, shopDescription));	
		System.out.println("Register Succesfully [press enter]");
		scan.nextLine();
		menu();
		
	}
	
	public void registerMenu() {
		System.out.println("Choose your role");
		System.out.println("1. Customer");
		System.out.println("2. Seller");
		int opt;
		do {
			System.out.print(">> ");
			opt = scan.nextInt();
			scan.nextLine();
		}while(opt < 1 || opt > 2);
		cls();
		switch (opt) {
		case 1:
			registerCustomer();
			break;
		case 2:
			registerSeller();
			break;
		}
		
	}
	
	public User login(String username, String password) {
		for (User user : userList) {
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					return user;
				}
		}
		return null;
	}
	
	public void loginMenu() {
		String username = "";
		String password = "";
		String error = "";
		currentUser = null;
		do{
			System.out.print("Username : ");
			username = scan.nextLine();
			System.out.print("Password : ");
			password = scan.nextLine();
			
			currentUser = login(username, password);
			if(username.isEmpty() || password.isEmpty()) {
				error = "All input must be filled";
			}else if(currentUser == null) {
				error = "User didn't exists!";
			}else {
				error = "";
			}
			
			
			if(!error.isBlank()) {
				System.out.println("\n" + error + " [press enter]");
				scan.nextLine();
			}
		}while(error != "");
		
		if(currentUser instanceof Seller) {
			sellerHome();
		}else if(currentUser instanceof Customer) {
			customerHome();
		}
		
	}
	
	
	public void cls() {
		for(int i=0;i<50;i++) {
			System.out.println();
		}
	}
	
	public void logout() {
		String inp;
		do {
			System.out.print(">> ");
			inp = scan.nextLine();
		}while(!inp.equals("logout"));
		currentUser = null;
		menu();
	}
	
	public void sellerHome() {
		cls();
		System.out.println("Features are still being developed ['logout' to Back to the menu]");
		logout();
	}

	public void print(int n, char c) {
		for(int i=0;i<n;i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	public void customerHome() {
		cls();
		print(68, '-');
		System.out.printf("| %-10s | %-15s | %-10s | %-20s |\n", "Number", "Shop Name", "Shop Type", "Shop Description");
		print(68, '-');
		int currNumber = 1;
		for (User user : userList) {
			if(user instanceof Seller) {
				Shop shop = ((Seller) user).getShop();
				System.out.printf("| %-10s | %-15s | %-10s | %-20s |\n", currNumber, shop.getName(), shop.getType(), shop.getDescription());
				currNumber += 1;
			}
		}
		print(68, '-');
		logout();
	}
	public void back() {
		System.out.println("\nWanna go back ? [press enter]");
		scan.nextLine();
		menu();
	}

	
	public void menu() {
		cls();
		System.out.println("Indo Market Place");
		System.out.println("---------------------");
		System.out.println("1. Login");
		System.out.println("2. Register");
		int opt;
		do {
			System.out.print(">> ");
			opt = scan.nextInt();
			scan.nextLine();
		}while(opt < 1 || opt > 2);
		cls();
		switch (opt) {
		case 1:
			loginMenu();
			break;
		case 2:
			registerMenu();
			break;
		}
	}
	
	public Main() {
		seed();
		menu();
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
