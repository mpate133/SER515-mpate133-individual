package DesignPattern;

import java.util.Iterator;

public class ProductIterator extends IteratorModal {
    public boolean hasNext(Iterator<Product> iterator) {
        return iterator.hasNext();
    }

    public Product next(Iterator<Product> iterator) {
        if (this.hasNext(iterator)) {
            return (Product) iterator.next();
        } else {
            return null;
        }
    }

    public void remove(Iterator<Product> iterator) {
        if (this.hasNext(iterator)) {
            iterator.next();
        }

    }

    public void moveToHead(Iterator<Product> iterator) {
        System.out.println("Head moved..");
    }

    
}
