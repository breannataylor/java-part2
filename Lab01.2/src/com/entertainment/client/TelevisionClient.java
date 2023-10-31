package com.entertainment.client;

import com.entertainment.Television;

public class TelevisionClient {
    public static void main(String[] args) {
        //no argument object
        Television tv1 = new Television();
        tv1.changeChannel(9);
        //two argument object
        Television tv2 = new Television("Sony",45);

        //printing toString
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println();

        //similar strings to demonstrate == vs. .equals()
        Television tv3 = new Television("Toshiba", 50);
        Television tv4 = new Television("Toshiba", 50);

        //demonstrating == vs. .equals(): == is obviously false
        System.out.println("tva3 == tvb" + (tv3 == tv4));
        System.out.println("tva3.equals(tv4)" + tv3.equals(tv4));
    }
}