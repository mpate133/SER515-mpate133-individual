package DesignPattern;

import java.util.Iterator;

public class OfferingIterator {
    
    public boolean hasNext(Iterator<Offering> offeringItr) {
        /*
         * this method checks if
         * the offeringItr (iterator) has 
         * its next object or not
         */
        return offeringItr.hasNext();
    }

    public void Remove(Iterator<Offering> offeringItr) {
        /*
         * here we will check if the iterator
         * has the next object or not;
         * If true, then we remove that.
         */
        if (this.hasNext(offeringItr)) {
            offeringItr.remove();
        }
    }

    public Offering Next(Iterator<Offering> offeringItr) {
        /* 
         * if the iterator has next object,
         * then we go to that object.
         */
        if(this.hasNext(offeringItr)) {
            return offeringItr.next();
        } 
        else {
            return null;
        }
    }

    public void MoveToHead(Iterator<Offering> offeringItr) {
        // moveToHead mentioned in class diagrams
        System.out.println("move to head method from Offering..");
    }

}
