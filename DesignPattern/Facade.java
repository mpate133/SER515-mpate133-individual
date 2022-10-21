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
		System.out.println("+++++++++++  Inside Facade Pattern  +++++++++++");

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

	public boolean login() {

		/*
		 * upon initializing Facade pattern
		 * user will be asked to login with 
		 * proper credentials via this method
		 */
		Login loginObj = new Login();

		setUserType(loginObj.selectTheTypeOfUser());

		if(UserType == 2){
			/* we have set 2 for exit */
			return false;
		}

		UserInfoItem user = loginObj.showLoginOptions();
		
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
			FileWriter fw = new FileWriter("DesignPattern/RecordFilesOfData/UserProduct.txt", true);
			/* in the file, we will append
			 userName:ValueOfProduct 
			 
			 ex : 
			 pepe:Beef
			 
			 */ 
			fw.write(this.userDetails.getNameOfTheUser()+":"+this.theSelectedProduct.getValueOfTheProduct() + "\n");
			fw.close();

		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createUser(UserInfoItem userInfo) {
		/*
		 * if the login is successful
		 * then we create a user and set the
		 * information in UserInfoItem class
		 */
		setUserType(userInfo.getTypeOfTheUser());
		setUserAsPerson(userInfo);
	}

	public void createProductList() {
		/*
		 * if the login is successful then
		 * we will create the product list.
		 */
		theProductList = new ClassProductList();
		theProductList.makeProductListFromDataset();
	}

	public void remind() {
		Reminder reminder = new Reminder();
		reminder.visitFacade(this);
	}

	public Product selectProduct() {
		/*
		 * this method will ask the user
		 * for the choices
		 */
		System.out.println("Select the product from given options...");
		// List<Product> products = this.theProductList.listOfTheProducts;
		Iterator<Product> iterator = this.theProductList.makeIteratorForOfferingList();
		ProductIterator productIterator = new ProductIterator();
		int i = 0;
		while(productIterator.hasNext(iterator)){
			/*
			 * this method will iterate
			 * through the product list
			 * and prints the products for user
			 * to select one from
			 */
			Product prItr = productIterator.Next(iterator);
			System.out.println(Integer.toString(i) + ". " + prItr.getNameOfTheProduct() + " : " + prItr.getValueOfTheProduct());
			i++;
		}
		System.out.println("Enter your selection...");
		int userSelectedOption = sc.nextInt();

		Product userSelectedProduct = this.theProductList.listOfTheProducts.get(userSelectedOption);

		/* 
		 * we will set the 
		 * nProductCategory 0 for Meat product
		 * and 1 for Produce product
		 */
		if(userSelectedProduct.getNameOfTheProduct().equals("Produce")){
			this.nProductCategory = 1;
			Product.typeOfTheProduct = 1;
		}
		else{
			this.nProductCategory = 0;
			Product.typeOfTheProduct = 0;
		}

		// printing the selected product and its category
		System.out.println("Your selected product is : " + userSelectedProduct.getValueOfTheProduct());
		System.out.println("Your selected product category is : " + userSelectedProduct.getNameOfTheProduct());

		return userSelectedProduct;
	}

	public void productOperation() {
		int action;
		while(true){
			/*
			 * unless the user press 3 for exit,
			 * we will keep the user in the loop 
			 * and will provide different actions to user
			 */
			System.out.println("Selecte your operation from below given options... : ");
			System.out.println("0. Create product menu");
			System.out.println("1. Show product menu");
			System.out.println("2. Remind user");
			System.out.println("3. Exit the system");

			action = sc.nextInt();

			if(action == 0 || action == 1){
				if(action == 0){
					/*
					 * product menu will be created
					 * if the user presses 0
					 */
					System.out.println("Creating the Product menu...");
					this.thePerson.CreateProductMenu();
				}
				/*these methods will  */
				this.thePerson.showMenu();
			}
			else if(action == 2){
				/*remind method will be called */
				remind();
			}
			else if(action == 3){
				/*
				 * Loop will be closed 
				 * and we exit the system as
				 * user has selected 3 for exit
				 */
				System.out.println("Exiting the system...");
				System.exit(0);
			}
			else{
				System.out.println("Please select an action from given choices");
			}
		}
	}

	public void setUserType(int typeOfUser){
		/*
		 * userType will be set
		 * as per the input of user;
		 * 0 for the sellers and 1 for the buyers
		 */
		this.UserType = typeOfUser;
	}

	public void setUserAsPerson(UserInfoItem userInfoItem){
		/*
		 * upon successful login,
		 * user will be set as a Person
		 * with the help of Factory pattern
		 */
		this.userDetails = userInfoItem;
		this.thePerson = FactoryPattern.createPerson(userInfoItem.getTypeOfTheUser());
	}

	private void startFacadeObject(){
		/*
		 * this method will initialize the facade pattern
		 * by calling the login() method
		 * and aking the types and credentials to user
		 */
		System.out.println("Facade Method is initiated.........");

		boolean isValidLogin = login();

		if(!isValidLogin){
			System.out.println("Login Failed...");
			return;
		}

		/*
		 * if the login is successful 
		 * then only we proceed furthur
		 */
		createProductList();
		this.theSelectedProduct = selectProduct();

		AttachProductToUser();
		productOperation();
	}

}
