package DesignPattern;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class OfferingList {
    
    List<Offering> listOfOffering;

    // Constructor for OfferingList class
    public OfferingList(){
        listOfOffering = new ArrayList<>();
    }

    public Iterator<Offering> makeIteratorForOfferingList() {
        // iterator for listOfOffering
        return this.listOfOffering.iterator();
    }
    
}
