package GitProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No506 {
    public static void main(String[] args) {
        String[] relativeRanks = findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        for (String s : relativeRanks){
            System.out.println(s);
        }
    }

    public static String[] findRelativeRanks(int[] score) {
        int[] clone = score.clone();
        Arrays.sort(clone);
        Map<Integer,Integer> map = new HashMap<>();
        String[] result = new String[score.length];
        for(int i = 0; i < clone.length; i++){
            map.put(clone[i], clone.length - 1 - i);
        }
        String[] describe = {"Gold Medal","Silver Medal","Bronze Medal"};

        for(int i = 0; i < score.length; i++){
            if(map.get(score[i]) < 3){
                result[i] = describe[map.get(score[i])];
            }else{
                result[i] = String.valueOf(map.get(score[i]) + 1);
            }
        }
        return result;
    }
}
