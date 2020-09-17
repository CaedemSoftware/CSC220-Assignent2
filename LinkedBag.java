/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment02PartA;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean removeAllOccurrences(T[][] entries) {
        //convert to 1d array
        System.out.println(" [-] Converting 2D array to 1D . . .");
        int i = 0;
        T[] temp = (T[]) new Object[entries[0].length + entries[1].length
                + entries[2].length + entries[3].length];
        for (T[] entrie : entries) {
            for (T entry : entrie) {
                temp[i] = entry;
                i++;
            }
        }

        //remove duplicates
        System.out.println(" [-] Removing duplicates in 1D array . . .");
        int k = temp.length - 1;;
        i = 0;
        while (i != temp.length - 1) {
            //compares values
            if (temp[i] == temp[k]) {
                temp[k] = null;
            }
            //iterator
            k--;
            //reset iterator
            if (k == i) {
                i++;
                k = temp.length - 1;
            }
        }

        //Display 1D array
        System.out.print(" [>] The final 1D array now contains: ");
        for (i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                System.out.print(temp[i] + " ");
            }
        }
        System.out.println("");

        //Remove contents of array from bag
        System.out.println(" [-] Removing the final 1D array items from"
                + " the bag . . .");
        Node currentNode = firstNode;
        while (currentNode != null) {
            for (i = 0; i < temp.length - 1; i++) {
                if (currentNode.data.equals(temp[i])) {
                    remove(temp[i]);
                }
            }
            currentNode = currentNode.next;
        }

        return true;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                //iterate through bag
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        //connects the nodes
        newNode.next = firstNode;
        //adds entry in the beginning
        firstNode = newNode;
        numberOfEntries++;

        return true;
    }

    @Override
    public T[] toArray() {
//        @SuppressWarnings("unchecked");
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        //while loop iterates through linked bag
        while ((index < numberOfEntries) && (currentNode != null)) {
            //makes copy of data to same position in array
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }

        return result;
    }

    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            //deletes the first node
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result;
    }

    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null) {
            //entry's data is replaced with first node's data
            nodeN.data = firstNode.data;
            //first node is deleted
            firstNode = firstNode.next;
            numberOfEntries--;
            result = true;
        }

        return result;
    }

    public int getFrequencyOf(T anEntry) {
        int frequency = 0;

        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }

            counter++;
            currentNode = currentNode.next;
        }

        return frequency;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return found;
    }

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}
