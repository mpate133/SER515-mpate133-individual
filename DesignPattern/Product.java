package DesignPattern;

public class Product {
    private String productName;
    private String value;

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
}
