package DesignPattern;

public class ProduceProductMenu implements ProductMenu {
    @Override
    public void showRadioButton() {
        System.out.println("Select produce product");
    }

    @Override
    public void showLabels() {
        System.out.println("Labels for the Produce product");
    }

    @Override
    public void showMenu() {

        System.out.println("Showing Produce Product Menu.......");
    }

    @Override
    public void showComboBoxes() {
        System.out.println("Combo boxes of Meat products");
    }

    @Override
    public void showAddButton() {

        System.out.println("Add produce product");
    }

    @Override
    public void showViewButton() {
        System.out.println("View produce Products");
    }

}
