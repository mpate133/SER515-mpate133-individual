package DesignPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Login {
    
    private int typeOfUser;
    private Scanner sc = new Scanner(System.in);


    public UserInfoItem showLoginOptions() {
        if(typeOfUser == 0) {
            System.out.println("Login for Sellers...");
        }
        else if(typeOfUser == 1){
            System.out.println("Login For Buyers...");
        }
    

        UserInfoItem userCredentials = enterLoginCredentials();

        if(userCredentials == null){
            System.out.println("Too many invalid attempts made for login");
            return null;
        }
        System.out.println("Login successful. Welcome :" + userCredentials.getNameOfTheUser());
        return userCredentials;

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
        /*
         we will allow 3 wrong login attemps, 
         after that we exit the system.
         */

        int wrongAttemptsCnt = 0;
        while(wrongAttemptsCnt<3){

            System.out.println("Enter your userName : ");
            String username = sc.next();
            System.out.println("Enter your password : ");
            String password = sc.next();
            boolean auth = authenticateUserCredentials(username, password);
            if(auth){
                return new UserInfoItem(typeOfUser, username, password);
            }
            else{
                wrongAttemptsCnt++;
            }
        }

        return null;
    }

}
