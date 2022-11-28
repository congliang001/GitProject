package GitProject;

import java.util.Arrays;

public class No49 {
    public static void main(String[] args) {
        No49 no49 = new No49();
        String s1 = no49.encode("bdddddddddd");
        String s2 = no49.encode("bbbbbbbbbbc");
        System.out.println(s1);
        System.out.println(s2);
    }
    public String encode (String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
