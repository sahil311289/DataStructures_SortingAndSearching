/*
Key function is pivot. Pick a random number as the pivot and partitions the array around the picked pivot.
1. Always pick the first element
2. Always pick the last element
3. Pick a random element
4. Pick the median

Method:
1. Given an array and an element 'x' of this array as a pivot, put x at its correct position in sorted array
2. Put all the smaller elements (smaller than x) before x
3. Put all the larger elements (larger than x) after x.

Time: O(n Log n) to O(n * n)
Space:
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] ar = {8, 4, 1, 6, 2, 5, 3, 7};
        int[] ar2 = {8, 4, 1, 6, 2, 5, 3, 7, 9};

        System.out.println("\nOriginal array: \n");
        for (int v: ar) {
            System.out.print(v+" ");
        }

        divide(ar, 0, ar.length-1);

        System.out.println("\nSorted array: \n");
        for (int v: ar) {
            System.out.print(v+" ");
        }
    }

    private static void divide(int[] ar, int start, int end) {
        if(start < end) {
            int pivot = partition(ar, start, end);

            divide(ar, start, pivot-1);
            divide(ar, pivot+1, end);
        }
    }

    private static int partition(int[] ar, int start, int end) {
        int pivot = ar[end];
        int i = start - 1;
        for(int j=start; j<end; j++) {
            if(ar[j] <= pivot) {
                i++;

                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        i++;
        int temp = ar[i];
        ar[i] = ar[end];
        ar[end] = temp;
        return i;
    }
}
