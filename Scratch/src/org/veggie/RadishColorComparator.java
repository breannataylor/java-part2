package org.veggie;
import java.util.Comparator;

class RadishColorComparator implements Comparator<Radish> {

    //sort key is color (String)
    @Override
    public int compare(Radish radish1, Radish radish2) {
        return radish1.getColor().compareTo(radish1.getColor());
    }
}