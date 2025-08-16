public class BubbleSrt{
    public static void main(String[] args){
        int[] arr = {5, 1, 4, 2, 8};
        bubbleSort(arr, 0, arr.length - 1);
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void bubbleSort(int[] arr, int c, int r){
        if(r==0) return;
        if(c < r){
            if(arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubbleSort(arr, c + 1, r);
        } else {
            bubbleSort(arr, 0, r - 1);
        }
    }
}