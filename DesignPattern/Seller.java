package DesignPattern;

public class Seller extends Person{
    public Seller(ProductMenu theProductMenu) {
        super(theProductMenu);
    }

    public Seller(){
        super(theProductMenu);
    }

    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu createProductMenu() {
        return null;
    }
}
