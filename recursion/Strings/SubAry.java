import java.util.*;
public class SubAry{
	public static void main(String[] args){
		int[] arr = {1,2,3};
		ArrayList<ArrayList<Integer>> list = subArray(arr);
		System.out.println(list.toString());
		int[] arr2 = {1,2,2};
		ArrayList<ArrayList<Integer>> list2 = subArrayDup(arr2);
		System.out.println(list2.toString());
	}
	public static ArrayList<ArrayList<Integer>> subArray(int[] arr){
		ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
		outer.add(new ArrayList<Integer>());
		for(int num:arr){
			int n = outer.size();
			for(int i = 0; i<n; i++){
				ArrayList<Integer> temp = new ArrayList<>(outer.get(i)); //here i
				temp.add(num);
				outer.add(temp);
			}
		}
		return outer;
	}
	public static ArrayList<ArrayList<Integer>> subArrayDup(int[] arr2){
		Arrays.sort(arr2); //to make duplicates together
		ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
		outer.add(new ArrayList<Integer>());
		int start = 0, end = 0;
		for(int i = 0; i<arr2.length; i++){
			start = 0;
			if(i>0 && arr2[i] == arr2[i - 1]){
				start = end + 1;
			}
			end = outer.size() - 1;
			int n = outer.size();
			for(int j = start; j<n; j++){
				ArrayList<Integer> temp = new ArrayList<>(outer.get(j)); //here j
				temp.add(arr2[i]);
				outer.add(temp);
			}
		}
		return outer;
	}
}