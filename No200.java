package GitProject;

public class No200 {
    boolean[][] visited;

    public static void main(String[] args) {
        No200 no200 = new No200();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'}
                        ,{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = no200.numIslands(grid);
        System.out.println(i);
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int ans = 0;
        dfs(grid,0,0);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    System.out.println("i :" + i + " j :" + j);
                    visited[i][j] = true;
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }


    public void dfs (char[][] grid,int row, int col){

        if(grid[row][col] == '1'){
            grid[row][col] = '0';
            int[][] move = new int [][] {{1,0},{-1,0},{0,1},{0,-1}};
            for(int i = 0; i < move.length; i++){
                int newRow = row + move[i][0];
                int newCol = col + move[i][1];
                if(newRow < 0 || newRow >= move.length || newCol < 0 || newCol >= move[0].length){
                    continue;
                }
                if(!visited[newRow][newCol]){
                     visited[newRow][newCol] = true;
                     dfs(grid,newRow,newCol);

               }

            }
            // visited[row][col] = true;
        }
    }
}
