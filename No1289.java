package GitProject;

public class No1289 {

    public static void main(String[] args) {
        No1289 no1289 = new No1289();
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7,8,9}};
        int i = no1289.minFallingPathSum(ints);
        System.out.println(i);
    }

//    public int minFallingPathSum(int[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        int[][] dp = new int [row][col];
//
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                if(i == 0){
//                    dp[i][j] = grid[i][j];
//                }else{
//                    int min = Integer.MAX_VALUE;
//                    for(int k = 0; k < col; k++){
//                        if(k != j){
//                            min = Math.min(min, dp[i - 1][k]);
//                        }
//                    }
//                    dp[i][j] = grid[i][j] + min;
//                }
//            }
//        }
//
//        int ans = dp[row - 1][0];
//        for(int i : dp[row - 1]){
//            ans = Math.min(i, ans);
//        }
//        return ans;
//    }


    public int minFallingPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int [row][col];
        int firstIndex = -1;
        int secondIndex = -1;
        for(int i = 0; i < col; i++){
            dp[0][i] = grid[0][i];
            if(grid[0][i] < (firstIndex == -1 ? Integer.MAX_VALUE : grid[0][firstIndex])){
                secondIndex = firstIndex;
                firstIndex = i;
            }else if (grid[0][i] < (secondIndex == -1 ? Integer.MAX_VALUE : grid[0][secondIndex])){
                secondIndex = i;
            }
        }

        for(int i  = 1; i < row; i++){
            int  tiFirst = -1, tiSecond = -1;
            for(int j = 0; j < col;j++){
                if(j != firstIndex){
                    dp[i][j] = grid[i][j] + grid[i - 1][firstIndex];
                }else {
                    dp[i][j] = grid[i][j] + grid[i - 1][secondIndex];
                }
                if(grid[i][j] < (tiFirst == -1 ? Integer.MAX_VALUE : grid[i][tiFirst])){
                    tiSecond = tiFirst;
                    tiFirst = j;
                }else if (grid[i][j] < (tiSecond == -1 ? Integer.MAX_VALUE : grid[i][tiSecond])){
                    tiSecond = j;
                }
            }
            firstIndex = tiFirst;
            secondIndex = tiSecond;
        }







        int ans = dp[row - 1][0];
        for(int i : dp[row - 1]){
            ans = Math.min(i, ans);
        }

        return ans;


    }



}
