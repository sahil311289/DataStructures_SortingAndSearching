/*
Searching in a sorted array
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(search(ar, 0, ar.length-1, 5));
    }

    private static int search(int[] ar, int start, int end, int n) {
        int mid = (start + end)/2;
        if(ar[mid] == n) {
            return mid;
        }
        if(ar[mid] > n) {
            return search(ar, start, mid-1, n);
        } else {
            return search(ar, mid + 1, end, n);
        }
    }
}
