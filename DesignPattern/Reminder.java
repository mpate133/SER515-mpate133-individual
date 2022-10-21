package DesignPattern;

public class Reminder {
    
    NodeVisitor nodeVisitor;

    // Constructor
    public Reminder(){

        /* 
         * as per the class diagram;
         * Reminder class user NodeVisitor and ClassProductList classes;
         * So printing "Visitor pattern on initialization"
        */
        System.out.println("+++++++++++++  Visitor Pattern - from Reminder Class  +++++++++++++");

        // nodeVisitor initialized with ReminderVisior class object;
        nodeVisitor = new ReminderVisitor();
    }

    // using suppressWarnings to remove warnings of type 'unused'.
    @SuppressWarnings("unused")
    public void visitProduct(Product product) {
        product.accept(nodeVisitor);
    }

    @SuppressWarnings("unused")
    public void visitTrading(Trading trading) {
        trading.accept(nodeVisitor);
    }

    public void visitFacade(Facade facade) {
        nodeVisitor.visitFacade(facade);
    }

    

}
