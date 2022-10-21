package DesignPattern;

public abstract class Person {
    
    public static ProductMenu theProductMenu;
    
    public abstract void showMenu();


    // constructor of Person class
    public Person(ProductMenu theProductMenu){
        Person.theProductMenu = theProductMenu;
    }

    // method to show Add button
    @SuppressWarnings("unused")
    private void showAddButton() {
        theProductMenu.showAddButton();
    }

    // method to show View button
    @SuppressWarnings("unused")
    private void showViewButton() {
        theProductMenu.showViewButton();
    }

    // metohod to show radio button
    @SuppressWarnings("unused")
    private void showRadioButton() {
        theProductMenu.showRadioButton();
    }

    // method to show labels.
    @SuppressWarnings("unused")
    private void showLabels() {
        theProductMenu.showLabels();
    }

    public abstract ProductMenu CreateProductMenu();
    
}
