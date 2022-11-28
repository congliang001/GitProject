package GitProject;

import java.util.ArrayList;
import java.util.List;

public class No438 {
    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] sarray = new int [26];
        int[] parray = new int [26];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < p.length(); i ++){
            parray[p.charAt(i) - 'a'] ++;
        }
        for(int left = 0, right = 0; right < s.length(); right ++){
            sarray[s.charAt(right) - 'a'] ++;
            if(right - left + 1 > p.length()){
                sarray[s.charAt(left) - 'a'] --;
                left ++;
            }
            if(compareDifferent(sarray,parray)){
                list.add(left);
            }
        }
        return list;
    }
    public static boolean compareDifferent(int[] array1, int[] array2){
        for(int i = 0; i < 26; i++){
            if(array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }
}
