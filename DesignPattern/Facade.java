package DesignPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
// import java.util.List;

public class Facade {

	private Scanner sc = new Scanner(System.in);

	// UserType = 0 for Seller and 1 for buyer
	private int UserType;
	// selected product by the user (meat of produce) 
	private Product theSelectedProduct;
	private int nProductCategory;
	private ClassProductList theProductList;
	private Person thePerson; // buyer or seller

	private UserInfoItem userDetails;


	public Facade(){
		System.out.println("*****************************");
		System.out.println("Inside Facade Pattern");
		System.out.println("*****************************");

		startFacadeObject();
	}

	public void addTrading() {
		System.out.println("Trading is being added....");
	}

	public void viewTrading() {
		System.out.println("Trading is being viewed....");
	}

	public void decideBidding() {
		System.out.println("Bidding is being decided....");
	}

	public void discussBidding() {
		System.out.println("Bidding is being discussed....");
	}

	public void submitBidding() {
		System.out.println("Bidding is being submitted....");
	}


	private void startFacadeObject(){
		System.out.println("Facade Method is initiated.........");

		boolean isValidLogin = login();

		if(!isValidLogin){
			System.out.println("Login Failed...");
			return;
		}

		createProductList();
		this.theSelectedProduct = selectProduct();

		AttachProductToUser();
		productOperation();
		// selectProductFromMenu();
	}

	public boolean login() {

		Login loginObj = new Login();

		setUserType(loginObj.selectTheTypeOfUser());

		if(UserType == 2){
			/* we have set 2 for exit */
			return false;
		}

		UserInfoItem user = loginObj.displayLoginOptions();
		
		if(user == null){
			return false;
		}
		createUser(user);
		return true;
	}

	public void AttachProductToUser() {
		/*
		 * this method will write the username and 
		 * selected product in our textfile UserProduct.txt (our Result file)
		 */

		try {
			FileWriter fw = new FileWriter("DesignPattern/TextFiles/UserProduct.txt");
			/* in the file, we will append
			 userName:ValueOfProduct 
			 
			 ex : 
			 pepe:Beef
			 
			 */ 
			fw.write(this.userDetails.getUserName()+":"+this.theSelectedProduct.getValue());
			fw.close();

		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createUser(UserInfoItem userInfo) {
		setUserType(userInfo.getUserType());
		setUserAsPerson(userInfo);
	}

	public void createProductList() {
		theProductList = new ClassProductList();
		theProductList.makeProductListFromDataset();
	}

	public void remind() {
		Reminder reminder = new Reminder();
		reminder.visitFacade(this);
	}

	public Product selectProduct() {
		System.out.println("Select the product from given options...");
		// List<Product> products = this.theProductList.listOfTheProducts;
		Iterator<Product> iterator = this.theProductList.createIterator();
		ProductIterator productIterator = new ProductIterator();
		int i = 0;
		while(productIterator.hasNext(iterator)){
			Product prItr = productIterator.next(iterator);
			System.out.println(Integer.toString(i) + ". " + prItr.getProductName() + " : " + prItr.getValue());
			i++;
		}
		System.out.println("Enter your selection...");
		int userSelectedOption = sc.nextInt();

		Product userSelectedProduct = this.theProductList.listOfTheProducts.get(userSelectedOption - 1);

		if(userSelectedProduct.getProductName().equals("Produce")){
			this.nProductCategory = 1;
			Product.typeOfTheProduct = 1;
		}
		else{
			this.nProductCategory = 0;
			Product.typeOfTheProduct = 0;
		}

		System.out.println("Your selected product is : " + userSelectedProduct.getValue());
		System.out.println("Your selected product category is : " + userSelectedProduct.getProductName());

		return userSelectedProduct;
	}

	public void productOperation() {
		int action;
		while(true){
			System.out.println("Selecte your operation from below given options... : ");
			System.out.println("0. Create product menu");
			System.out.println("1. Show product menu");
			System.out.println("2. Remind user");
			System.out.println("3. Exit the system");

			action = sc.nextInt();

			if(action == 0 || action == 1){
				if(action == 0){
					System.out.println("Creating the Product menu...");
					this.thePerson.CreateProductMenu();
				}
				this.thePerson.showMenu();
				Person.theProductMenu.showAddButton();
				Person.theProductMenu.showLabels();
				Person.theProductMenu.showRadioButton();
				Person.theProductMenu.showViewButton();
				Person.theProductMenu.showComboBoxes();
			}
			else if(action == 2){
				remind();
			}
			else if(action == 3){
				System.out.println("Exiting the system...");
				System.exit(0);
			}
			else{
				System.out.println("Please select an action from given choices");
			}
		}
	}

	public void setUserType(int typeOfUser){
		this.UserType = typeOfUser;
	}

	public void setUserAsPerson(UserInfoItem userInfoItem){
		this.userDetails = userInfoItem;
		this.thePerson = PersonFactory.createPerson(userInfoItem.getUserType());
	}

	// public void selectProductFromMenu(){
	// 	System.out.println("Select from the following menus :");
	// 	System.out.println("0. Meat Product Menu");
	// 	System.out.println("1. Produce Product Menu");

	// 	int menuOption = sc.nextInt();

	// 	switch (menuOption){
	// 		case 0:
	// 			this.theSelectedProduct = new Product("Meat", "");
	// 			break;
	// 		case 1:
	// 			this.theSelectedProduct = new Product("Produce", "");
	// 			break;
	// 		default:
	// 			throw new IllegalStateException("Unexpected value: " + menuOption);
	// 	}
	// }
}
