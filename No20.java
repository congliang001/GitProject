package GitProject;

import java.util.*;

public class No20 {

    public static void main(String[] args) {
        No20 no20 = new No20();
        boolean valid = no20.isValid("([)]");
        System.out.println(valid);

    }

    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if(deque.poll() != map.get(cur)){
                    return false;
                }
            }else{
                deque.push(cur);
            }
        }

        return deque.isEmpty();
    }
}
