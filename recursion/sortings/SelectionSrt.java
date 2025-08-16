public class SelectionSrt{
    public static void main(String[] args){
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr, arr.length - 1,0, 0);
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void selectionSort(int[] arr, int r, int c, int maxIndex){
        if(r == 0) return;
        if(c < r){
            if(arr[c] > arr[maxIndex]) selectionSort(arr, r, c + 1, c); //++c no use c+1 because c is passed by value for next maxIndex.
            else selectionSort(arr, r, ++c, maxIndex);
        }
        else{
            if(maxIndex != r){
                int temp = arr[r];
                arr[r] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
            selectionSort(arr, r - 1, 0, 0);
        }
    }
}