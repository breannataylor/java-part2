package com.javatunes.billing;

public class TaxCalculatorFactory {

    //prevents instantiation from outside, this is an all-static class
    private TaxCalculatorFactory() {
    }
    /*
     * If I have not previously created the object (e.g USATax), then I'll create it here,
     * add it to my cache, and then return it.
     *
     * However, if my cache already contains it, then I just fetch it
     * from the cache and return it - no need to create another one.
     *
     * Hint: you could use a simple Map<Location, TaxCalculator> for the cache.
     * It would be a 3-row Map, each row has Location | TaxCalculator
     */

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;
        switch (location) {
            case EUROPE:
                calc = new EuropeTax();
                break;
            case ONLINE:
                 calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
        }
        return calc;
    }
}