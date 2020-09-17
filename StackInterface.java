/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: StackInterface.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment02PartB;

public interface StackInterface<T>
{
   public void push(T newEntry);
   public T pop();
   public T peek();
   public boolean isEmpty();
   public void clear();
}
