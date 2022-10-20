package DesignPattern;

public class PersonFactory extends Person {
    public PersonFactory(ProductMenu theProductMenu) {
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
        System.out.println("***************************************");
        System.out.println("Factory Pattern");
        System.out.println("***************************************");

        switch (typeOfUser){
            case 0:
                person = new Seller();
                System.out.println("Object for seller is created!");
                break;
            case 1:
                person = new Buyer();
                System.out.println("Object for Buyer is created!");
                break;
            default:
                throw new IllegalStateException("Entered value is wrong: " + typeOfUser);
        }
        return person;
    }
}
