public class SelectionSrt{
    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        //find the maximum element in unsorted array and swap it with the last unsorted element
        //this is repeated until the array is sorted.
        for(int i = 0; i<arr.length; i++){
            int lastIndex = arr.length - 1 - i;
            int maxIndex = findMaxIndex(arr, lastIndex);
            if(maxIndex != lastIndex){
                int temp = arr[lastIndex];
                arr[lastIndex] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
    public static int findMaxIndex(int[] arr, int lastIndex){
        int maxIndex = 0;
        for(int i=0; i<=lastIndex; i++){
            if(arr[i] > arr[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }
}