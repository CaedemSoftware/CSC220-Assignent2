/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */

package assignment02PartC;

import java.util.Random;

public class BlurbGenerator {
    Random rand;
    int i;

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        this.rand = new Random();
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb() {
        return makeWhoozit() + makeMultiWhatzits(rand.nextInt(5) + 1);
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {
        return "x" + makeYString(rand.nextInt(6));
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString(int x) {
        if(x != 0){
            return makeYString(x - 1) + "y";
        } 
        return "";
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits(int x) {
        if(x != 0){
            return makeMultiWhatzits(x -1) + makeWhatzit();
        }
        return "";
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatzit() {
        String rest = null;
        switch(rand.nextInt(2)){
            case 0: rest = "z"; break;
            case 1: rest = "d"; break;
    }
        return "q" + rest + makeWhoozit();
    }
}


