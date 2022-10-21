package DesignPattern;

import java.util.Iterator;

public class ProductIterator {

    public void Remove(Iterator<Product> prdItr) {
        /*
         * here we will check if the iterator
         * has the next object or not;
         * If true, then we remove that.
         */
        if (this.hasNext(prdItr)) {
            prdItr.remove();
        }

    }

    public Product Next(Iterator<Product> prdItr) {
        /* 
         * if the iterator has next object,
         * then we go to that object.
         */
        if (this.hasNext(prdItr)) {
            return (Product) prdItr.next();
        } else {
            return null;
        }
    }

    public boolean hasNext(Iterator<Product> prdItr) {
        /*
         * this method checks if
         * the prdItr (product iterator) has 
         * its next object or not
         */
        return prdItr.hasNext();
    }

    public void MoveToHead(Iterator<Product> prdItr) {
        System.out.println("move to head method...");
    }

    
}
