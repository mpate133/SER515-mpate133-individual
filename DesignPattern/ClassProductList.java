package DesignPattern;

import java.io.BufferedReader;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import java.util.ArrayList;


public class ClassProductList {
    List<Product> productList;
    public ClassProductList(){
        productList = new ArrayList<>();
    }

    public void makeProductListFromDataset(){
        try{
            File file = new File("DesignPattern/TextFiles/ProductInfo.txt");

            BufferedReader bufferReader= new BufferedReader(new FileReader(file));

            String lineReader;

            while (bufferReader.readLine() != null) {
                lineReader = bufferReader.readLine();
                String[] temp = lineReader.split(":");
                productList.add(new Product(temp[0], temp[1]));
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    // iterator for iterator pattern
    public Iterator<Product> createIterator() {
        return this.productList.iterator();
    }

    // public Reminder accept(NodeVisitor visitor) {
    //     System.out.println("Reminder for product list........");
    //     return visitor.visitProduct(this);
    // }
}
