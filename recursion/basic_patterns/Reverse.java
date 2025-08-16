import java.util.*;
public class Reverse{
    public static void main(String[] args){
        Scanner seenu = new Scanner(System.in);
        int n = seenu.nextInt();
        int ans = reverse(n);
        System.out.println(ans);
        if(ans == n) System.out.println("Palindrome");  //its palindrome for nums.
        else System.out.println("Not a Palindrome");
    }
    public static int reverse(int n){
        if(n < 10) return n;
        return (n%10) * (int)Math.pow(10, (int)Math.log10(n)) + reverse(n/10);
    }
}