package DesignPattern;

public class Product {
    
    /*
     * these variables tell us
     * the type of product (Meat or Produce);
     * the name of the product and;
     * the value of product
     */
    public static int typeOfTheProduct; 
    private String nameOfTheProduct;
    private String valueOfTheProduct;

    /* Constructor of Product class, 
     * to initialize the values of local variables
     */
    public Product(String productName, String value){
        this.nameOfTheProduct = productName;
        this.valueOfTheProduct = value;
    }

    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitProduct(this);
    }

   /*
    * method to return the value of the product 
    * example; beef, tomato, onion etc.
    */
    public String getValueOfTheProduct(){
        return this.valueOfTheProduct;
    }

    /*
     * method to return product names;
     * for example: Meat or Produce
     */
    public String getNameOfTheProduct(){
        return this.nameOfTheProduct;
    }

    
}
