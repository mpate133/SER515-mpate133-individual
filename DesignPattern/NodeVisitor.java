package DesignPattern;

public abstract class NodeVisitor {

    public abstract void visitFacade(Facade facade);

    public abstract void visitProduct(Product product);

    public abstract void visitTrading(Trading trading);

}
