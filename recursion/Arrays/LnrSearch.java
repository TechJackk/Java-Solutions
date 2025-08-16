public class LnrSearch{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        System.out.println(linearSearch(arr, 30, 0));
    }
    public static boolean linearSearch(int[] arr,int target, int index){
        if(index == arr.length - 1) return arr[index] == target;;
        return arr[index] == target || linearSearch(arr, target,++index);
    }
}