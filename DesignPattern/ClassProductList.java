package DesignPattern;

import java.io.File;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import java.util.ArrayList;


public class ClassProductList {
    
    List<Product> listOfTheProducts;
    
    // Constructor
    public ClassProductList(){
        listOfTheProducts = new ArrayList<>();
    }

    public void makeProductListFromDataset(){
        /*
         * This method reads the whole
         * product list from given file 'ProductInfo.txt'
         * and add the product to 'listOfTheProducts'
         */
        try{
            File file = new File("DesignPattern/RecordFilesOfData/ProductInfo.txt");

            BufferedReader bfr = new BufferedReader(new FileReader(file));

            String lineReader;

            while ((lineReader = bfr.readLine()) != null) {
                /*
                 * lineReader will be in the format of
                 * name:value; example:- Meat:beef
                 * so here we will separate them with split function
                 */
                String[] prod = lineReader.split(":");

                listOfTheProducts.add(new Product(prod[0], prod[1]));
            }
            bfr.close();
        }
        catch (Exception exception){
            // Auto-generated catch block
            exception.printStackTrace();
        }
    }

    // iterator for iterator pattern
    public Iterator<Product> makeIteratorForOfferingList() {
        return this.listOfTheProducts.iterator();
    }

    public void accept(NodeVisitor visitor) {
        System.out.println("Reminder for product list........");
    }
}
