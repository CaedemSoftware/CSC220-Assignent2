/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PascalsTriangleGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment02PartD;

public class PascalsTriangleGenerator {

    public PascalsTriangleGenerator() {
    }

    //row + 1 in main
    public int[] computeRow(int row) {
        int[] array = new int[row];
        int[] array0 = new int[row - 1];
        int i = 1;
        if (row == 1) {
            array[0] = 1;
        }
        if (row == 2) {
            array[1] = 1;
            array[0] = 1;
        } else {
            while (i < row - 1) {
                array[0] = 1;
                array[row - 1] = 1;
                array0 = computeRow(row - 1);
                array[i] = array0[i] + array0[i - 1];
                i++;
            }
        }
        return array;
    }
}
