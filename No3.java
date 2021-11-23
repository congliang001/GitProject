package GitProject;

import java.util.HashSet;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int  right = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        for(int left = 0; left < s.length(); left++){
            if(left != 0){
                set.remove(s.charAt(left - 1));
            }
            while(right < s.length()){
                if(set.contains(s.charAt(right))){
                    break;
                }else{
                    set.add(s.charAt(right));
                    if(right != s.length() - 1){
                        right ++;
                    }
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
