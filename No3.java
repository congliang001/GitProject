package GitProject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdefghij"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        for(left = 0, right = 0; right < s.length(); right ++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right),right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
