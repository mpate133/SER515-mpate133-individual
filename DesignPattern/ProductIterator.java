package DesignPattern;

import java.util.Iterator;
import java.util.List;

public class ProductIterator extends ListIterator {
    public boolean hasNext(Iterator<Product> iterator) {
        return iterator.hasNext();
    }

    public void moveToHead(Iterator<Product> iterator) {
        System.out.println("Head moved..");
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
}
