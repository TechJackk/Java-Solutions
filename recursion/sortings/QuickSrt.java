public class QuickSrt{
    public static void main(String[] args){
        int[] arr = {64, 25, 12, 22, 11};
        quickSort(arr, 0, arr.length - 1);
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low >= high) return;
        int s = low, e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];
        while(s <= e){
            while(s <= e && arr[s] < pivot) s++;
            while(s <= e && arr[e] > pivot) e--;
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}