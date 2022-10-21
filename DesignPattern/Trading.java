package DesignPattern;

public class Trading {

    /*
     * added "accept" method 
     * according to the class diagram;
     * which visits the Trading class
     */
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitTrading(this);
    }

}
