package DesignPattern;

public class MeatProductMenu implements ProductMenu {
    @Override
    public void showMenu() {
        /*print message for the showing menu */
        System.out.println("Showing Meat Product Menu.......");
    }

    @Override
    public void showRadioButton() {
        // print message for showing radio buttons
        System.out.println("Select meat product");
    }

    @Override
    public void showAddButton() {
        // print message for add button
        System.out.println("Add Meat Product");
    }

    @Override
    public void showLabels() {
        // print message for showing labels
        System.out.println("Labels for the Meat product");
    }

    @Override
    public void showViewButton() {
        // print message for showing view button
        System.out.println("View Meat Products");
    }

    @Override
    public void showComboBoxes() {
        // print message for showiung combo boxes
        System.out.println("Combo boxes of Meat products");
    }
}
