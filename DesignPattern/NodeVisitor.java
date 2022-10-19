package DesignPattern;

public abstract class NodeVisitor {

    public abstract void visitFacade(Facade facade);

    public abstract Reminder visitProduct(ClassProductList product);

    public abstract Reminder visitTrading(ClassProductList trading);

}
