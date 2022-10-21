package DesignPattern;

public class Seller extends Person{

    /*
     * Buyer and Seller will fall within Bridge pattern;
     */

    // Constructor
    public Seller(){
        super(theProductMenu);
    }

    @Override
    public void showMenu() {

        /*
         * this method will be same as in Buyer class;
         * we will check if theProductMenu is instance of
         * type Meat or Produce
         */

        if(theProductMenu instanceof ProduceProductMenu){
            System.out.println("Produce Product Menu...");
        }
        else{
            System.out.println("Meat Product Menu...");
        }
    }

    @Override
    public ProductMenu CreateProductMenu() {
        /* this is the method to create and set 
         * the menu according 
         * to the seller's selection
         */
        switch(Product.typeOfTheProduct){
            case 1:
                theProductMenu = new ProduceProductMenu();
                break;
            case 0:
                theProductMenu = new MeatProductMenu();
            default:
                System.out.println("Invalid Choice...");
                break;
        }

        return theProductMenu;
    }
}
