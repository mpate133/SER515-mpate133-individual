package DesignPattern;

public class ReminderVisitor extends NodeVisitor{

    // Private variable as per the class diagram
    @SuppressWarnings("unused")
    private Reminder m_Reminder;

    @Override
    public void visitFacade(Facade facade) {
        System.out.println("Reminder for Facade Class.......");
    }

    @Override
    public void visitProduct(Product productObject) {
        System.out.println("Reminder for Product Class.......");
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Reminder for Trading Class.......");
    }
}
