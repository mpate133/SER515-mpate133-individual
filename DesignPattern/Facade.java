package DesignPattern;

import java.util.*;
// import java.util.List;

public class Facade {

	private final Scanner sc = new Scanner(System.in);

	// userType = 0 for Seller and 1 for buyer
	private int userType;
	// selected product by the user (meat of produce) 
	private Product theSelectedProduct;
	private int nProductCategory;
	private ClassProductList theProductList;
	private Person thePerson; // buyer or seller


	public Facade(){
		System.out.println("*****************************");
		System.out.println("Facade Pattern");
		System.out.println("*****************************");

		initiateFacadePattern();
	}

	private void initiateFacadePattern(){
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
		Login loginObject = new Login();
		setUserType(loginObject.selectTheTypeOfUser());
		if(userType == 2){
			/* we have set 2 for exit */
			return false;
		}

		UserInfoItem user = loginObject.displayLoginOptions();
		if(user == null){
			return false;
		}
		createUser(user);
		return true;
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

	public void remind() {
		Reminder reminder = new Reminder();
		reminder.visitFacade(this);
	}

	public void createUser(UserInfoItem userInfo) {
		setUserType(userInfo.getUserType());
		setUserAsPerson(userInfo);
	}

	public void createProductList() {
		theProductList = new ClassProductList();
		theProductList.makeProductListFromDataset();
	}

	public void AttachProductToUser() {

	}

	public Product selectProduct() {
		System.out.println("Select the Product...");
		// List<Product> products = this.theProductList.productList;
		Iterator<Product> iterator = this.theProductList.createIterator();
		ProductIterator productIterator = new ProductIterator();
		int i = 0;
		while(productIterator.hasNext(iterator)){
			Product product = productIterator.next(iterator);
			System.out.println(Integer.toString(i) + ". " + product.getProductName() + " : " + product.getValue());
			i++;
		}
		System.out.println("Select an option...");
		int selectedOption = sc.nextInt();

		Product selectedProduct = this.theProductList.productList.get(selectedOption - 1);
		System.out.println("Your selected product is : " + selectedProduct.getProductName());

		return selectedProduct;
	}

	public void productOperation() {

	}

	public void setUserType(int typeOfUser){
		this.userType = typeOfUser;
	}

	public void setUserAsPerson(UserInfoItem userInfoItem){
		this.thePerson = PersonFactory.createPerson(userInfoItem.getUserType());
	}

	public void selectProductFromMenu(){
		System.out.println("Select from the following menus :");
		System.out.println("0. Meat Product Menu");
		System.out.println("1. Produce Product Menu");

		int menuOption = sc.nextInt();

		switch (menuOption){
			case 0:
				this.theSelectedProduct = new Product("Meat", "");
				break;
			case 1:
				this.theSelectedProduct = new Product("Produce", "");
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + menuOption);
		}
	}
}
