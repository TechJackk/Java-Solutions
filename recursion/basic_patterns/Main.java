import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner seenu = new Scanner(System.in);
        int n = seenu.nextInt();
        int ans = product(n);
        System.out.println(ans);
    }
    public static int product(int n){
        if(n<10) return n;
        return (n%10) * product(n/10);
    }
}