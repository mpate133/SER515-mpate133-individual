package DesignPattern;

import java.util.Iterator;

public abstract class IteratorModal {
    public abstract boolean hasNext(Iterator<Product> iterator);

    public abstract Product next(Iterator<Product> iterator);

    public abstract void remove(Iterator<Product> iterator);

    public abstract void moveToHead(Iterator<Product> iterator);
}
