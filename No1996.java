package GitProject;

import java.util.Arrays;

public class No1996 {
    public static void main(String[] args) {
        No1996 no1996 = new No1996();
        int[][] array = new int [][] {{5,6},{5,5},{5,5}};
        int i = no1996.numberOfWeakCharacters(array);
        System.out.println(i);
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }
}
