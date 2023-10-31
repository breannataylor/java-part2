package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

public class TelevisionClient {
    public static void main(String[] args) {
        //similar strings to demonstrate == vs. .equals()
        Television tv3 = new Television("Toshiba", 50);
        Television tv4 = new Television("Toshiba", 65);

        //demonstrating == vs. .equals(): == is obviously false
        System.out.println("tva3 == tv4: " + (tv3 == tv4));
        System.out.println("tva3.equals(tv4): " + tv3.equals(tv4));
        System.out.println();

        System.out.println(tv3.hashCode());
        System.out.println(tv4.hashCode());
        System.out.println();

        Set<Television> tvs = new HashSet<>();
        tvs.add(tv3);
        tvs.add(tv4); //should be rejected as a duplicate
        System.out.println("The size of the set is: " + tvs.size());
    }
}