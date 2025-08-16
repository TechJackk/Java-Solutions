import java.util.*;
public class PhonePad{
    public static void main(String[] args){
        String str = "12";
        ArrayList<String> result = phonePad("", str);
        System.out.println(result);
        System.out.println(padCount(str));
    }
    public static ArrayList<String> phonePad(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> bases = new ArrayList<>();
            bases.add(p);
            return bases;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> res = new ArrayList<>();
        for(int i = (digit - 1) * 3; i<digit * 3; i++){
            char ch = (char)('a' + i);
            res.addAll(phonePad(p + ch, up.substring(1)));
        }
        return res;
    }
    public static int padCount(String up){
        if(up.isEmpty()){
            return 1;
        }
        int digit = up.charAt(0) - '0';
        int count = 0;
        for(int i = (digit - 1) * 3; i<digit * 3; i++){
            count += padCount(up.substring(1));
        }
        return count;
    }
}