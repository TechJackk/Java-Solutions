import java.util.*;
public class SkipA {
    public static void main(String[] args) {
        String str = "bcacappleade";
        System.out.println(skipFun(str));
        System.out.println(skipApple(str));
    }
    public static String skipFun(String up){
        if(up.isEmpty()) return "";

        char ch = up.charAt(0);
        if( ch == 'a') return skipFun(up.substring(1));
        else return ch + skipFun(up.substring(1));
    }
    public static String skipApple(String up){
        if(up.isEmpty()) return "";

        char ch = up.charAt(0);
        if(up.startsWith("apple")) return skipApple(up.substring(5));
        else return ch + skipApple(up.substring(1));
    }
}