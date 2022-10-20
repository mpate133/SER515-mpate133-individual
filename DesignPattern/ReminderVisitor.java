package DesignPattern;

public class ReminderVisitor extends NodeVisitor{

    private Reminder m_Reminder;

    @Override
    public void visitFacade(Facade facade) {
        System.out.println("Visiting Facade Class.......");
    }

    @Override
    public void visitProduct(Product productObject) {
        System.out.println("Visiting Product Class.......");
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Visiting Trading Class.......");
    }
}
