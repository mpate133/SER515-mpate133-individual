package DesignPattern;

public abstract class NodeVisitor {

    public abstract void visitFacade(Facade facadeObject);

    public abstract Reminder visitProduct(ClassProductList productObject);

    public abstract Reminder visitTrading(ClassProductList x);

}
