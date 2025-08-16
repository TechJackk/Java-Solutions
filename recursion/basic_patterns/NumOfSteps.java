import java.util.*;
public class NumOfSteps{
    public static void main(String[] args){
        Scanner seenu = new Scanner(System.in);
        int n = seenu.nextInt();
        int ans = countSteps(n, 0);
        System.out.println(ans);
    }
    public static int countSteps(int n, int steps){
        if(n == 0) return steps;
        if(n % 2 == 0) return countSteps(n/2, ++steps);
        else return countSteps(n - 1, ++steps);
        // This function counts the number of steps to reduce n to 0 by either halving or subtracting 1. its a leetcode problem.
    }
}