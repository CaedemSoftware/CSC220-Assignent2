/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbsDriver.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment02PartC;

import java.util.Scanner;

public class BlurbsDriver {

    public static void main(String args[]) {
        BlurbGenerator blurbMaker = new BlurbGenerator();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number of blurbs: ");
        int numBlurbs = scan.nextInt();
        for (int i = 1; i <= numBlurbs; i++) {
            System.out.println("Blurb #" + i + ": " + blurbMaker.makeBlurb());
        }
    }
}