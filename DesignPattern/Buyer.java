package DesignPattern;

public class Buyer extends Person{
    public Buyer(){
        super(theProductMenu);
    }

    @Override
    public void showMenu() {

        System.out.println("********************************");
        System.out.println("Bridge Pattern");
        System.out.println("********************************");

        // here we will check and print if theProductMenu is instance of MeatProductMenu or ProduceProductMenu.
        if(theProductMenu instanceof ProduceProductMenu){
            System.out.println("Produce Product Menu...");
        }
        else{
            System.out.println("Meat Product Menu...");
        }
    }


    // method to create and set the menu according to the buyer's selection
    @Override
    public ProductMenu CreateProductMenu() {
        if(Product.typeOfTheProduct == 0){
            theProductMenu = new MeatProductMenu();
        }else{
            theProductMenu = new ProduceProductMenu();
        }
        return theProductMenu;
    }
}
