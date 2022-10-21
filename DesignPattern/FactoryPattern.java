package DesignPattern;

public class FactoryPattern extends Person {
    
    // Constructure
    public FactoryPattern(ProductMenu theProductMenu) {
        super(theProductMenu);
    }

    @Override
    public void showMenu() {}

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }

    public static Person createPerson(int typeOfUser){
        
        Person person;

        System.out.println("++++++++++++++   Factory Pattern   +++++++++++++");

        if(typeOfUser == 0){
            /*
             * seller object will be created
             * and message will be printed
             */
            person = new Seller();
            System.out.println("Object for seller is created!");
            return person;
        }
        else if(typeOfUser == 1){
             /*
             * Buyer object will be created
             * and message will be printed
             */
            person = new Buyer();
            System.out.println("Object for Buyer is created!");
            return person;
        }
        else{
            /*
             * error message will be printed
             */
            System.out.println("You have entered wrong value; Please enter from 0 or 1.");
        }

        return null;
    }
}
