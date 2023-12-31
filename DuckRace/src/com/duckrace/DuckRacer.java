package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    //fields
    private final int id;
    private String name;
    //creating an empty Collection to hold Rewards - I can now populate the Collection and do something with it.
    private final Collection<Reward> rewards = new ArrayList<>();

    //constructor
    public DuckRacer (int id, String name){
        this.id = id;
        setName(name);
    }

    //business methods
    // receives decided reward as an argument, then adds that reward to the Collection<Rewards>
    public void win(Reward reward) {
        rewards.add(reward);
    }

    //accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //derived property - the amount of wins is derived from the amount of prizes a racer has
    public int getWins() {
        return rewards.size();
    }
    /*
     * Instead of returning a direct reference to the collection,
     * we return a READ-ONLY review.
     */
    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
        // return List.copyOf(rewards);
    }

    @Override
    public String toString(){
        return String.format("%s: id: %s, name: %s, wins: %s, rewards: %s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}