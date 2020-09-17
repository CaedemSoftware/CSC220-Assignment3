package assignment03PartB2;

/**
 *
 * Part B.2
 *
 * Please do not change any code in the main method
 *
 */
public class ArraySortByFirst {

    public static void sortByFirst(int data[][]) {
        int i = 0;
        int j = i + 1;
        while (data[0][0] > data[1][0] || data[1][0] > data[2][0] || data[2][0]
                > data[3][0] || data[3][0] > data[4][0]) {
            if (data[i][0] > data[j][0]) {
                int[] temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            i++;
            j++;
            if (j == data.length) {
                i = 0;
                j = i + 1;
            }
        }
    }

    public static void display(int data[][]) {
        for (int[] datum : data) {
            for (int j = 0; j < datum.length; j++) {
                System.out.print(datum[j] + " ");
            }
            System.out.println("");
        }
    }

    //
    // Please do not change any code in the main method
    //
    public static void main(String args[]) {
        int array[][] = {{1, 2, 3, 4, 5},
        {3, 4, 5, 1, 2},
        {5, 2, 3, 4, 1},
        {2, 3, 1, 4, 5},
        {4, 2, 3, 1, 5}};

        System.out.println("The array is initially ");
        display(array);
        System.out.println();

        sortByFirst(array);
        System.out.println("The array after sorting is ");
        display(array);
        System.out.println();
    }
}
