import java.util.Scanner;
public class CntZeros{
    public static void main(String[] args){
        Scanner seenu = new Scanner(System.in);
        int n = seenu.nextInt();
        int c = 0; // Initialize count of zeros
        int ans = countZeros(n , c);
        System.out.println(ans);
    }
    public static int countZeros(int n, int c){
        if(n < 10) return n == 0 ? ++c : c; // If n is 0, return count + 1, else return count
        if(n % 10 != 0) return countZeros(n/10, c);
        else if(n % 10 == 0) return countZeros(n/10, ++c);
        return 0; // This line is unreachable but included for completeness, since above all returns are inside a if condition java will require a
        // general return statement for completeness.
    }
}