import java.util.*;
public class MergeSrt{
    public static void main(String[] args){
        int[] arr = {64, 25, 12, 22, 11};
        int[] ans = mergeSort(arr);
        arr = ans; // Assign the sorted array back to arr
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }
    public static int[] merge(int[] start, int[] end){
        int i = 0, j = 0, k = 0;
        int[] merged = new int[start.length + end.length];
        while(i<start.length && j<end.length){
            if(start[i] < end[j]) merged[k++] = start[i++];
            else merged[k++] = end[j++];
        }

        while(i < start.length) merged[k++] = start[i++];
        while(j < end.length) merged[k++] = end[j++];
        return merged;
    }
}