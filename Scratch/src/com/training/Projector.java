package com.training;

class Projector {
    /*
     * This is a demo on class loading
     */

    public Projector () {
        //this is to see when the constructor gets invoked.
        System.out.println("Projector ctor called.");
    }

    //this executes when the class loader loads Projector.class into memory. This is done at runtime.
    static {
        System.out.println("Projector.class loaded into memory.");
    }
}