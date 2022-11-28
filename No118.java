package GitProject;

import java.util.ArrayList;
import java.util.List;

public class No118 {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] triangle = new int[numRows][];
        for(int i = 0; i < numRows; i ++){
            List<Integer> line = new ArrayList<> ();
            triangle[i] = new int [i + 1];
            for(int j = 0; j <= i; j ++){
                if(j == 0 || j == i){
                    triangle[i][j] = 1;
                }else{
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
            }
            for(int n : triangle[i]){
                line.add(n);
            }
            result.add(line);
        }
        return result;
    }
}
