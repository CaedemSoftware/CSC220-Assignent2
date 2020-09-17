/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PalindromeChecker.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment02PartB;

import java.util.Scanner;

//
// - Do not change the "main" method.
// - Please ADD CODE to complete implementing the program
//
public class PalindromeChecker {

    private static boolean isPalindrome(String string) {
        //ignore casing & punctuation
        string = string.toLowerCase().replaceAll("\\s", "").replaceAll("\\p{Punct}", "");
        OurStack stack = new OurStack<>();
        int index = 0;

        for (int i = 0; i < string.length(); i++) {
                stack.push(string.charAt(i));
        }

        while (!stack.isEmpty() && index < string.length()) {
            //returns false is opposite side doesn't match
            if (!stack.peek().equals(string.charAt(index))) {
                return false;
                //iterate through stack    
            } else {
                stack.pop();
            }
            index++;
        }

        return true;

    } // end isPaired

    //
    // - Do not change the "main" method.
    // - Please ADD CODE to complete implementing the program
    //
    public static void main(String[] args) {
        //
        // - Do not change the "main" method.
        // - Please ADD CODE to complete implementing the program
        //
        Scanner input = new Scanner(System.in);
        System.out.print("[>>] Enter a string (or a ! to exit): ");
        String string = input.nextLine();

        while (!string.equals("!")) {
            if (isPalindrome(string)) {
                System.out.println(" [+] Yes. \"" + string + "\" IS a palindrome!");
            } else {
                System.out.println(" [-] No. \"" + string + "\" is NOT a palindrome!");
            }
            System.out.print("[>>] Enter a string: ");
            string = input.nextLine();
        }

        System.out.println("[<<] Thank you!");
        //
        // - Do not change the "main" method.
        // - Please ADD CODE to complete implementing the program
        //
    }
}
