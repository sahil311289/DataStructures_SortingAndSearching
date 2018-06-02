/*
1. Split the array into 2 halves recursively until only individual elements are left
2. Start merging elements into 1 array
3. Add remaining elements into the array

Time: O(n Log n)
Space: O(n)
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] ar = {8, 4, 1, 6, 2, 5, 3, 7};
        int[] ar2 = {8, 4, 1, 6, 2, 5, 3, 7, 9};

        System.out.println("\nOriginal array 1: \n");
        for (int v: ar) {
            System.out.print(v+" ");
        }

        divide(ar, 0, ar.length-1);

        System.out.println("\nSorted array 1: \n");
        for (int v: ar) {
            System.out.print(v+" ");
        }

        System.out.println("\nOriginal array 2: \n");
        for (int v: ar2) {
            System.out.print(v+" ");
        }

        divide(ar2, 0, ar.length-1);

        System.out.println("\nSorted array 2: \n");
        for (int v: ar2) {
            System.out.print(v+" ");
        }
    }

    private static void divide(int[] ar, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            divide(ar, start, mid);
            divide(ar, mid + 1, end);

            mergeSorted(ar, start, mid, end);
        }
    }

    private static void mergeSorted(int[] ar, int start, int mid, int end) {

        // Get lengths of the arrays
        int length1 = mid - start + 1;
        int length2 = end - mid;

        // Instantiate arrays
        int[] leftAr = new int[length1];
        int[] rightAr = new int[length2];

        // Initialize arrays
        for(int i=0; i<length1; i++) {
            leftAr[i] = ar[start+i];
        }
        for(int i=0; i<length1; i++) {
            rightAr[i] = ar[mid+1+i];
        }

        int k = start, i = 0, j = 0;
        while(i<length1 && j<length2) {
            if(leftAr[i] <= rightAr[j]) {
                ar[k] = leftAr[i];
                i++;
            }
            else {
                ar[k] = rightAr[j];
                j++;
            }
            k++;
        }

        // Add remaining elements to ar
        while(i<length1) {
            ar[k] = leftAr[i];
            k++;
            i++;
        }
        while(j<length2) {
            ar[k] = rightAr[j];
            k++;
            j++;
        }
    }
}
