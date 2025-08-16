import java.util.*;
public class Permut {
    public static void main(String[] args){
        String str = "abc";
        ArrayList<String> permutations = new ArrayList<>();
        permutation("", str, permutations);
        System.out.println(permutations.toString());
    }
    public static void permutation(String p, String up, ArrayList<String> permutations){
        if(up.isEmpty()){
            permutations.add(p);
            return;
        }
        for(int i=0; i<=p.length(); i++){
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            char ch = up.charAt(0);
            permutation(f + ch + s, up.substring(1), permutations);
        }
    }
}