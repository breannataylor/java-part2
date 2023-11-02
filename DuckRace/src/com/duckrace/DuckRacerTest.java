package com.duckrace;

import java.util.Collection;

class DuckRacerTest {

    public static void main(String[] args) {
        //instantiate a new racer
        DuckRacer racer = new DuckRacer(14, "Scott");
        System.out.println(racer);

        //make it win a few times;
        racer.win(Reward.PRIZES);
        racer.win(Reward.PRIZES);
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);
        System.out.println(racer);

        // to show read only view to the underlying collection
        Collection<Reward> rewards = racer.getRewards();
        System.out.println(rewards);    //should see 4

        // two more honest wins that update's the DuckRacer's rewards collection to now have it.
        racer.win(Reward.DEBIT_CARD);
        racer.win(Reward.DEBIT_CARD);
        System.out.println(rewards);    //should now show 6 without refetching the collection

    }

}