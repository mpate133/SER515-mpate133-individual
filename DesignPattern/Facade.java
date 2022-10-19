package DesignPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Facade {

	private final Scanner inputScanner = new Scanner(System.in);

	private int userType;
	private Product theSelectedProduct;
	private int nProductCategory;
	private ClassProductList theProductList;
	private Person thePerson;


	public Facade(){
		System.out.println("*****************************");
		System.out.println("Facade Pattern");
		System.out.println("*****************************");

		initiateFacade();
	}

	private void initiateFacade(){
		System.out.println("Facade Method is initiated.........");

		boolean isLoginSuccessful = login();
		if(!isLoginSuccessful){
			System.out.println("Login not successful");
			return;
		}
		createProductList();
		inputProductSelection();
		this.theSelectedProduct = selectProduct();
		System.out.println("Your selected product is : " + this.theSelectedProduct.getProductName());
	}

	public boolean login() {
		Login loginObject = new Login();
		setUserType(loginObject.userTypeSelection());
		if(userType == 2){
			return false;
		}
		UserInfoItem user = loginObject.displayLoginForm();
		if(user == null){
			return false;
		}
		createUser(user);
		return true;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {
		setUserType(userinfoitem.getUserType());
		setPerson(userinfoitem);
	}

	public void createProductList() {
		theProductList = new ClassProductList();
		theProductList.readProductList();
	}

	public void AttachProductToUser() {

	}

	public Product selectProduct() {
		System.out.println("Select the Product...");
		List<Product> products = this.theProductList.productList;
		Iterator<Product> iterator = (Iterator<Product>) this.theProductList.createIterator();
		ProductIterator productIterator = new ProductIterator();
		int index = 0;
		while(productIterator.hasNext(iterator)){
			Product product = productIterator.next(iterator);
			System.out.println(Integer.toString(index) + " " + product.getProductName() + " " + product.getValue());
			index++;
		}
		System.out.println("Select an option...");
		int option = inputScanner.nextInt();

		Product selectedProduct = this.theProductList.productList.get(option - 1);
		return selectedProduct;
	}

	public void productOperation() {

	}

	public void setUserType(int typeOfUser){

		this.userType = typeOfUser;
	}

	public void setPerson(UserInfoItem userInfoItem){
		this.thePerson = PersonFactory.createPerson(userInfoItem.getUserType());
	}

	public void inputProductSelection(){
		System.out.println("Select from the following menus :");
		System.out.println("0. Meat Product Menu");
		System.out.println("1. Produce Product Menu");

		int menuOption = inputScanner.nextInt();

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
