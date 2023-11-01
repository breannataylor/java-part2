package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelevisionClient {
    public static void main(String[] args) {
        //similar strings to demonstrate == vs. .equals()
        Television tv3 = new Television("Sony", 50);
        Television tv4 = new Television("Sony",50 );
        Television tv5 = new Television("Hitachi", 40);
        Television tv6 = new Television("LG", 76);

        //demonstrating == vs. .equals(): == is obviously false
        System.out.println("tva3 == tv4: " + (tv3 == tv4));
        System.out.println("tva3.equals(tv4): " + tv3.equals(tv4));
        System.out.println();


        Set<Television> tvs = new TreeSet<>();
        tvs.add(tv3);
        tvs.add(tv4);//rejected as duplicate
        tvs.add(tv5);
        tvs.add(tv6);

        System.out.println("The size of the set is: " + tvs.size());
        for(Television tv : tvs){
            System.out.println(tv);
        }

    }
}