package DesignPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Login {
    private int typeOfUser;
    private Scanner inputScanner = new Scanner(System.in);


    private boolean authentication(String username, String userPassword){
        File fileReader;
        if(typeOfUser == 0){
            fileReader = new File("DesignPattern/TextFiles/SellerInfo.txt");
        }
        else{
            fileReader = new File("DesignPattern/TextFiles/BuyInfo.txt");
        }
        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(fileReader));
            String lineReader;
            while ((lineReader = bufferReader.readLine()) != null)
            {
                String[] userCredentials = lineReader.split(":",2);
                if(username.equals(userCredentials[0])) {
                    if(userPassword.equals(userCredentials[1])) {
                        return true;
                    }
                    break;
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception occurred while reading the file. Check the data is correct or not !!");
            exception.printStackTrace();
        }
        System.out.println("Invalid Credentials. Please try again!!");
        return false;
    }

    protected UserInfoItem displayLoginForm() {
        switch(typeOfUser) {
            case 0:
                System.out.println("Seller Login Form");
                break;
            case 1:
                System.out.println("Buyer Login Form");
                break;
            default:
                break;
        }

        UserInfoItem userObject = inputCredentials();
        if(userObject == null){
            System.out.println("10 invalid attempts made for login. Temporary logged out of the menu !!");
            return null;
        }
        System.out.println("Login successful. Welcome :" + userObject.getUserName());
        return userObject;

    }

    public int userTypeSelection(){
        boolean validInput = false;

        while(!validInput){
            System.out.println("Please select any option from the following :");
            System.out.println("0 : Seller");
            System.out.println("1 : Buyer");
            System.out.println("2 : Exit Program");

            typeOfUser = inputScanner.nextInt();
            if(typeOfUser == 0 || typeOfUser == 1 || typeOfUser == 2){
                validInput = true;
            }
        }
        return typeOfUser;
    }

    private UserInfoItem inputCredentials() {
        int countWrongAttempts = 0;
        while(true){
            if(countWrongAttempts >= 10){
                return null;
            }
            System.out.println("Please enter username : ");
            String scannedUsername = inputScanner.next();
            System.out.println("Please enter password : ");
            String scannedPassword = inputScanner.next();
            if(authentication(scannedUsername, scannedPassword)){
                return new UserInfoItem(typeOfUser, scannedUsername, scannedPassword);
            }
            else{
                countWrongAttempts++;
            }
        }
    }
}
