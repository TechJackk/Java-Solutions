import java.util.ArrayList;
public class MulOccur{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 3, 6};
        System.out.println(multipleOccurrences(arr, 3, 0, new ArrayList<Integer>()));
    }
    public static ArrayList<Integer> multipleOccurrences(int[] arr, int target, int index, ArrayList<Integer> indeces){
        if(index == arr.length) return indeces;
        if(arr[index] == target) indeces.add(index);
        return multipleOccurrences(arr, target, ++index, indeces);
    }
}