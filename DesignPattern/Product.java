package DesignPattern;

public class Product {
    private String productName;
    private String value;
    public static int typeOfTheProduct; // this variable tells us if the product is of type Meat or type Produce.

    public Product(String productName, String value){
        this.productName = productName;
        this.value = value;
    }

    public String getProductName(){
        return this.productName;
    }

    public String getValue(){
        return this.value;
    }

    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitProduct(this);
    }
}
