package DesignPattern;

public class Trading {
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitTrading(this);
    }
}
