package DesignPattern;

public class UserInfoItem {
   
    // name of the user
    private String userName;

    // user's password
    private String password;

    // if the user is a Buyer or a Seller
    private int typeOfTheUser; 

    // Constructor of the UserInfoItem class
    public UserInfoItem(int typeOfUser, String name, String passWord){
        /*
         * initialisation of the local variables
         */
        this.typeOfTheUser = typeOfUser;
        this.userName = name;
        this.password = passWord;
    }


    public String getNameOfTheUser() {
        /*
         * returns the name of user;
         * example: pepe, mimi etc.
         */
        return userName;
    }

    public int getTypeOfTheUser(){
        /*
         * returns the type of user;
         * 0 for Buyers and
         * 1 for Sellers
         */
        return typeOfTheUser;
    }

    public String getPasswordOfTheUser() {
        /*
         * returns the password of 
         * currently loggedIn user
         */
        return password;
    }
}
