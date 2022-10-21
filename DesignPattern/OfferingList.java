package DesignPattern;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class OfferingList {
    
    List<Offering> listOfOffering;

    // Constructor
    public OfferingList(){
        listOfOffering = new ArrayList<>();
    }

    public Iterator<Offering> makeIteratorForOfferingList() {
        return this.listOfOffering.iterator();
    }
    
}
