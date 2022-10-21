package DesignPattern;

public class MeatProductMenu implements ProductMenu {
    @Override
    public void showMenu() {

        System.out.println("Showing Meat Product Menu.......");
    }

    @Override
    public void showRadioButton() {
        System.out.println("Select meat product");
    }

    @Override
    public void showAddButton() {

        System.out.println("Add Meat Product");
    }

    @Override
    public void showLabels() {
        System.out.println("Labels for the Meat product");
    }

    @Override
    public void showViewButton() {
        System.out.println("View Meat Products");
    }

    @Override
    public void showComboBoxes() {
        System.out.println("Combo boxes of Meat products");
    }
}
