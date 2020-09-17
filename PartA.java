/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: <Part A>
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment03PartA;

/**
 *
 * @author Ze Lei <SFSU>
 */
public class PartA {

    public static void main(String[] args) {
        int[] data = {9, 5, 9, 8, 3, 3, 6, 2, 9, 7, 6, 1};
        int[] copy1 = data.clone();
        int[] copy2 = data.clone();
        System.out.println("Selection Sort\n---");
        System.out.println("Unsorted array:");
        printArray(data);
        selectionSort(data);
        System.out.println("Sorted array");
        printArray(data);
        System.out.println("---\nInsertion Sort\n---");
        System.out.println("Unsorted array:");
        printArray(copy1);
        insertionSort(copy1);
        System.out.println("Sorted array");
        printArray(copy1);
        System.out.println("---\nShell Sort\n---");
        System.out.println("Unsorted array:");
        printArray(copy2);
        shellSort(copy2);
        System.out.println("Sorted array");
        printArray(copy2);
    }

    public static void selectionSort(int[] array) {
        System.out.println("[Numbers in brackets] are unsorted");
        int n = array.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;

            System.out.println("Step " + (i + 1));
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k]);
                System.out.print(" ");
                if (k == i) {
                    System.out.print("[");
                }
            }
            System.out.println("\b]");
        }
    }

    public static void insertionSort(int[] array) {
        System.out.println("[Numbers in brackets] are sorted");
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
            
            //print steps
            System.out.println("Step " + (i));
            System.out.print("[");
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k]);
                if (k == i) {
                    System.out.print("]");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }

    }

    public static void shellSort(int[] array) {
        System.out.println("Numbers with dots. have been switched");
        int n = array.length;
        int l = 1;

        // Start with a big gap, then reduce the gap 
        for (int gap = n / 2; gap > 1; gap /= 2) {
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already 
            // in gapped order keep adding one more element 
            // until the entire array is gap sorted 
            for (int i = gap; i < n; i++) {
                // store value 
                int temp = array[i];

                // shift earlier gap-sorted elements up until 
                // the correct location for temp is found 
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // put in correct location
                array[j] = temp;
                
                System.out.println("Step " + l);
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k]);
                if (k == j){
                    System.out.print(".");
                }
                if (k == i && j != i) {
                    System.out.print(".");
                }
                System.out.print(" ");
            }
            System.out.println("");
            l++;
            }
        }
        System.out.println("---\nInsertion Portion");
        insertionSort(array);
    }

    // Prints the array
    public static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
