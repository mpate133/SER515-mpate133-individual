package DesignPattern;

public class Buyer extends Person{
    
    /*
     * Buyer and Seller will fall within Bridge pattern;
     */
    public Buyer(){
        super(theProductMenu);
    }

    @Override
    public void showMenu() {

        /*
        * Buyer and Seller will fall within Bridge pattern;
        */

        System.out.println("+++++++++++++  Bridge Pattern  ++++++++++");

        /* here we will check and print 
        * if theProductMenu is instance of
        * MeatProductMenu or ProduceProductMenu.
        */
        if(theProductMenu instanceof ProduceProductMenu){
            System.out.println("Produce Product Menu...");
        }
        else{
            System.out.println("Meat Product Menu...");
        }
    }


    /* this is the method to create and set 
    * the menu according 
    * to the buyer's selection
    */
    @Override
    public ProductMenu CreateProductMenu() {
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
