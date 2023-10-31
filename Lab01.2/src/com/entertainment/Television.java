package com.entertainment;

import java.util.Objects;

public class Television {
    //fields
    private String brand;
    private int volume;

    private Tuner tuner = new Tuner();

    //constructors
    public Television(){

    }

    public Television(String brand, int volume){
        setBrand(brand);
        setVolume(volume);

    }

    //business methods
    public int getCurrentChannel(){
        return tuner.getChannel();
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel);
    }
    //accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode(){
        /*
         * This is a poorly written hash function, because it easily yields "has collisions."
         * A hash collision is when "different" objects have the same hash code (join by coincident.)
         *
         *        return getBrand().length() + getVolume();
         * Instead, we rely on Objects.has() to give us a "scientifically correct" hash function.
         */
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;

        //proceed only if 'obj' is really referencing a Television object
        if (obj instanceof Television){
           //safely downcast 'obj' to more specific reference type Television
           Television other = (Television) obj;

           //business equality is defined by brand and volume being the same.
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe check
                    this.getVolume() == other.getVolume();                  // primitives can't be null
        }

        return result;
    }

    //toString
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " brand:" + getBrand() +
                " volume: " + getVolume() +
                " currentChannel: " + getCurrentChannel();
    }
}