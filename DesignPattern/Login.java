package DesignPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Login {
    private int typeOfUser;
    private Scanner sc = new Scanner(System.in);


    protected UserInfoItem displayLoginOptions() {
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

        UserInfoItem userObject = enterLoginCredentials();
        if(userObject == null){
            System.out.println("10 invalid attempts made for login. Temporary logged out of the menu !!");
            return null;
        }
        System.out.println("Login successful. Welcome :" + userObject.getUserName());
        return userObject;

    }

    public int selectTheTypeOfUser(){
        boolean isValidInput = false;

        while(!isValidInput){
            System.out.println("Please select any option from the following :");
            System.out.println("0 : Seller");
            System.out.println("1 : Buyer");
            System.out.println("2 : Exit Program");

            typeOfUser = sc.nextInt();
            if(typeOfUser == 0 || typeOfUser == 1 || typeOfUser == 2){
                isValidInput = true;
            }
        }
        return typeOfUser;
    }

    private boolean authenticateUserCredentials(String userName, String userPassword){
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
                String[] credentialsArr = lineReader.split(":",2);
                if(userName.equals(credentialsArr[0])) {
                    if(userPassword.equals(credentialsArr[1])) {
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

    private UserInfoItem enterLoginCredentials() {
        int wrongAttemptsCnt = 0;
        while(true){
            if(wrongAttemptsCnt >= 10){
                return null;
            }
            System.out.println("Please enter userName : ");
            String userName = sc.next();
            System.out.println("Please enter password : ");
            String password = sc.next();
            if(authenticateUserCredentials(userName, password)){
                return new UserInfoItem(typeOfUser, userName, password);
            }
            else{
                wrongAttemptsCnt++;
            }
        }
    }
}
