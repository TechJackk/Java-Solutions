public class Dice{
    public static void main(String[] args){
        int target = 4;
        System.out.println("All possible outcomes for a dice roll summing to " + target + ":");
        possibilities("", target);
    }
    public static void possibilities(String p, int target){
        if(target == 0){
            System.out.print(p + " ");
            return;
        }
        for(int i = 1; i<=6 && i<=target; i++) possibilities(p + i, target - i);
    }
}