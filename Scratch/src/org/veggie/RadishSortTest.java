package org.veggie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        //color, size, tailLenth, sprouts
        radishes.add(new Radish("red",  2.1, 1.0, 0));
        radishes.add(new Radish("white", 1.0, 0.0, 3));
        radishes.add(new Radish("red", 2.5, 4.2, 0));
        radishes.add(new Radish("purple", 0.7, 3.2, 2));

        //original order
        System.out.println("original order");
        dump(radishes);
        System.out.println();
        //natural order - passing null means do it by natural order
        System.out.println("natural order: size");
        radishes.sort(null);
        dump(radishes);
        System.out.println();

        System.out.println("color, via anonymous Comparator<Radish> class:");
        //radishes.sort(new RadishColorComparator());
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return r1.getColor().compareTo(r2.getColor());
            }
        });
        dump(radishes);
        System.out.println();

        System.out.println("sprouts, via RadishSproutsComparator:");
        radishes.sort(new RadishSproutsComparator());
        dump(radishes);
        System.out.println();

        System.out.println("sort by tailLength, via anonymous class");
        //implents radish Comparator - instead of writing an entirely new class that you many never need
        //anywhere else, you can write an 'on the fly' implementation class that implements the interface
        radishes.sort(new Comparator<Radish>() {
            //compare method
            @Override
            public int compare(Radish r1, Radish r2) {
                return Double.compare(r1.getTailLength(), r2.getTailLength());
            }
        });
        dump(radishes);
    }

    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes) {
            System.out.println(radish);
        }
    }
}