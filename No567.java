package GitProject;

import java.util.HashMap;
import java.util.Map;

public class No567 {
    public static void main(String[] args) {
        No567 no567 = new No567();
        String s1 = "trinitrophenylmethylnitramine";
        String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
//        for(int i = 0; i < s2.length(); i++){
//            System.out.println(i + " : " + s2.charAt(i));
//        }
        System.out.println(no567.checkInclusion(s1,s2));
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = 0,count = need.size(), valid = 0;
        while(right < s2.length()){
            char r = s2.charAt(right);
            right++;
            window.put(r,window.getOrDefault(r, 0) + 1);
            if(window.get(r).equals(need.get(r))){
                valid++;
            }
            while(right - left >= s1.length()){
                if(valid == count){
                    return true;
                }
                if(left == 22){
                    System.out.println(" ");
                }
                char l = s2.charAt(left);
                left++;
                window.put(l,window.get(l) - 1);
                if(need.containsKey(l)){
                    if(window.get(l) < need.get(l)){
                        valid--;
                    }
                }

            }
        }
        return false;
    }
}
