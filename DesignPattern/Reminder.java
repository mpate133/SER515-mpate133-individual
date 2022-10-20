package DesignPattern;

public class Reminder {
    private NodeVisitor nodeVisitor;

    // Constructor
    public Reminder(){
        System.out.println("********************************");
        System.out.println("Visitor Pattern");
        System.out.println("********************************");

        // nodeV isitor initialized with ReminderVisior class object;
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
