import java.util.*;
class subset2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dupSubset(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public static void dupSubset(List<List<Integer>> res, List<Integer> temp, int[] arr, int start){
        res.add(new ArrayList<>(temp));
        for(int i = start; i<arr.length; i++){
            if(i > start && arr[i - 1] == arr[i]) continue; //includes 1st occur of dup ele and skips 2nd time
            temp.add(arr[i]);
            dupSubset(res, temp, arr, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
