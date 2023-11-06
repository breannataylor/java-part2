package com.training;

class Instructor {

    //instance variables for each instructor object.
    private final String name;
    private final int yearsExp;

    //shared among all Instructor objects
    private static final Projector projector = new Projector();

    //constructor
    public Instructor(String name, int yearsExp) {
        System.out.println("Instructor ctor called.");
        this.name = name;
        this.yearsExp = yearsExp;
    }

    public static void touch(){
        System.out.println("Instructor's touch() method called.");
    }

    //accessor methods - getters only
    //setters must be used as the may be used for data configuration now or in the future. getters only = ready only.
    public String getName() {
        return name;
    }

    public int getYearsExp() {
        return yearsExp;
    }



    static {
        System.out.println("static fields initialized, Instructor.class loaded into memory.");
    }
}