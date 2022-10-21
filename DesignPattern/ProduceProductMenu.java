package DesignPattern;

public class ProduceProductMenu implements ProductMenu {
    @Override
    public void showRadioButton() {
        // print message for showing radio buttons
        System.out.println("Select produce product");
    }

    @Override
    public void showLabels() {
        // print message for showing labels
        System.out.println("Labels for the Produce product");
    }

    @Override
    public void showMenu() {
        /*print message for the showing menu */
        System.out.println("Showing Produce Product Menu.......");
    }

    @Override
    public void showComboBoxes() {
        // print message for showiung combo boxes
        System.out.println("Combo boxes of Meat products");
    }

    @Override
    public void showAddButton() {
        // print message for add button
        System.out.println("Add produce product");
    }

    @Override
    public void showViewButton() {
        // print message for showing view button
        System.out.println("View produce Products");
    }

}
