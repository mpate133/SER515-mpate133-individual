package DesignPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Login {

    /*
     * typeOf user defines whether
     * the user is a Buyer or a Seller;
     * 0 for Seller; and 1 for Buyer
     */
    private int buyerOrSeller;
    private Scanner sc = new Scanner(System.in);


    public UserInfoItem showLoginOptions() {
        /*
         * this method will ask the user 
         * for credentials and
         * based on the input, we will validate the username and passwords
         */
        if(buyerOrSeller == 0) {
            System.out.println("Login for Sellers...");
        }
        else if(buyerOrSeller == 1){
            System.out.println("Login For Buyers...");
        }
    

        UserInfoItem creds = enterLoginCredentials();

        if(creds == null){
            /*
             * cred == null means that user has tried wrong attemps for 3 times
             */
            System.out.println("Too many invalid attempts made for login");
            return null;
        }

        System.out.println("Login successful. Welcome :" + creds.getNameOfTheUser());
        return creds;

    }

    public int selectTheTypeOfUser(){
        /*
         * this method will print
         * login options for user
         * to login as a buyer or a seller
         */
        // boolean isValidInput = false;
        buyerOrSeller = -1;

        while(buyerOrSeller != 0 && buyerOrSeller != 1 && buyerOrSeller != 2){
            /*
             * loop will continue to run
             * if user select anything else
             * other than given choices 
             * which are 0, 1 and 2
             */
            System.out.println("Please select any option from the following :");
            System.out.println("0 : Seller");
            System.out.println("1 : Buyer");
            System.out.println("2 : Exit Program");

            buyerOrSeller = sc.nextInt();
            // if(buyerOrSeller == 0 || buyerOrSeller == 1 || buyerOrSeller == 2){
            //     isValidInput = true;
            // }
        }
        return buyerOrSeller;
    }

    private boolean validateUserCredentials(String userName, String userPassword){
        /*
         * here we will validate the user credentials
         * by checking the file data
         */
        File fR = new File("DesignPattern/RecordFilesOfData/BuyerInfo.txt");

        if(buyerOrSeller == 0){
            fR = new File("DesignPattern/RecordFilesOfData/SellerInfo.txt");
        }
        /*
         * in above code, first we assigned fr as BuyerInfo.txt
         * and if user is logged in as seller, then only
         * we will assign fr as SellerInfo.txt
         * By doing this we have override the use of 'else' block;
         */
        
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fR));
            String lineReader;
            while ((lineReader = bfr.readLine()) != null)
            {
                String[] credentialsArr = lineReader.split(":",2);
                if(userName.equals(credentialsArr[0])) {
                    if(userPassword.equals(credentialsArr[1])) {
                        return true;
                    }
                    /*
                     * we will breakout of the loop as 
                     * one user can have only one password
                     */
                    break;
                }
            }
            
        } catch (Exception exception) {
            // Auto-generated catch block
            System.out.println(exception);
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

        for(int i=0; i<3; i++){
            System.out.println("Enter your userName : ");
            String username = sc.next();
            System.out.println("Enter your password : ");
            String password = sc.next();
            
            boolean auth = validateUserCredentials(username, password);
            
            if(auth){
                return new UserInfoItem(buyerOrSeller, username, password);
            }
        }

        /*
         * if the user has made 3 attempts 
         * and still not able to login,
         * we will return null.
         */
        return null;
    }

}
