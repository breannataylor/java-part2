package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap; - K is integer, V is DuckRacer
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();

    /*
     * updates board by making a DuckRacer "win"
     * This could mean fetching aexisting DuckRacer from racerMpa,
     * or we might need to create a new DuckRacer, put it in the map,
     * and then make it "win."
     *
     * Either way, it needs to "win".
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;
        //you can ask a map if it contains a key
        if (racerMap.containsKey(id)) { // id present, fetch DuckRacer
            racer = racerMap.get(id);
        }
        else {  // id not present, so here we create new DuckRacer
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
    }

    //TESTING PURPOSES ONLY
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }
    /*
     * // TODO: render the data so it looks like the board you see every day
     * consider using a StringBuilder and append() instead of a myriad of sout calls.
     * Duck Race Results
     * =================
     *
     * id   name    wins    rewards
     * --   ----    ----    -------
     * 1    BreAnna 4       PRIZES
     * 18   Senna   1       REWARDS
    */
    public void show(){
        Collection<DuckRacer> racers = racerMap.values();
        if (racerMap.isEmpty()) {
            System.out.println("\nThere are currently no results to show.\n");
        }
        else
            for (DuckRacer racer : racers) {
                System.out.printf("%s   %s    %s     %s\n",
                        racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
            }
    }

    public int maxId() {
        //the maximum size is the maximum number id number
        return studentIdMap.size();
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        //read all lines from conf/student-ids.csv into a List<String>
        //the only way this can fail is that the file name is wrong or the file isn't there
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            //for each line, split it into "tokens," i.e., "1, Aaron" is split into "1" and "Aaron"
            for (String line : lines) {
                String[] tokens = line.split(","); //tokens[0] is "1", and tokens[1] is "Aaron"

                //convert tokens as necessary
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }

}