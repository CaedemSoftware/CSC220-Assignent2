/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Assignment02PartE01.java
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */

package assignment02PartE;

public class Assignment02PartE01 {
    public static void main(String[] args) {
        //n = 5, sum = 5: 2 assignment operations; 2ops
        int i, n = 5, sum = 5;
        //i = 5: 1 assignment op; 1ops
        //i < 3 * n: 1 comparison & 1 multiplcation per loop; (n+1)*2 ops
        //EXE: sum = sum * n + i * 7 + 37; 1 assignment, 2 multiplcation, 2 addition; (n+1)*5 ops
        //i++: 1 assignment, 1 addition; (n+1)*2 ops
        for (i = 5; i < 3 * n; i++) {
            sum *= n + i * 7 + 37;
        }
        System.out.println(sum);
    }
    /*
    //Total OPS: 
    At 3n + 1 loops
    Before loop: 2
    For loop: 1 + (3n+2)*2 + (3n+1)*5 + (3n+1)*2
    
    Simplify: 3 + 6n + 4 + 15n + 5 + 6n + 2
    Group like terms: 7 + 7 + 21n + 6n
    27n + 14
    //n = 5
    //27 * 5 + 14 = 149 operations
*/
}
