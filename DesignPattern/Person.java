package DesignPattern;

public abstract class Person {
    protected static ProductMenu theProductMenu;
    public abstract void showMenu();
    public abstract ProductMenu createProductMenu();

    public Person(ProductMenu theProductMenu){
        this.theProductMenu = theProductMenu;
    }

    private void showAddButton() {
        this.theProductMenu.showAddButton();
    }

    private void showViewButton() {
        this.theProductMenu.showViewButton();
    }

    private void showRadioButton() {
        this.theProductMenu.showRadioButton();
    }

    private void showLabels() {
        this.theProductMenu.showLabels();
    }
}
