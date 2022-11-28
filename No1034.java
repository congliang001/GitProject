package GitProject;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1034 {
    int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
    int[][] result;
    int lines, columns;

    public static void main(String[] args) {
        int[][] ints = new No1034().colorBorder(new int [][]{{1, 1}, {1, 2}}, 0, 0, 3);
        for (int i = 0; i < ints.length; i++) {
            for(int j = 0; j < ints[0].length; j++){
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }

    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        lines = grid.length;
        columns = grid[0].length;
        int[][] _result = new int [lines][columns];
        result = _result;
        dfs(row,col,color,grid);
        for(int i = 0; i < lines; i++){
            for(int j = 0; j < columns; j++){
                if(result[i][j] == 0){
                    result[i][j] = grid[i][j];
                }
            }
        }
        return result;
    }

    public  void dfs(int x, int y,int color,int[][] grid){
        int count = 0;
        for(int i = 0; i < move.length; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(nx < 0 || nx >= lines || ny < 0 || ny >= columns){
                continue;
            }
            if(grid[x][y] == grid[nx][ny]){
                count ++;
            }else{
                continue;
            }
            if(result[nx][ny] != 0){
                continue;
            }
            result[nx][ny] = -1;
            dfs(nx,ny,color,grid);
        }
        if(count == 4){
            result[x][y] = grid[x][y];
        }else{
            result[x][y] = color;
        }
    }







    public static int[][] colorBorder2(int[][] grid, int row, int col, int color){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] remove = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] result = new int [rows][cols];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[]{row,col});
        while(!queue.isEmpty()){
            int count = 0;
            int[] location = queue.pollFirst();
            int x = location[0];
            int y = location[1];
            for(int i = 0; i < remove.length; i++){
                int nx = x + remove[i][0];
                int ny = y + remove[i][1];
                if(nx < 0 || nx >= rows || ny < 0 || ny >= cols){
                    continue;
                }
                if(grid[x][y] == grid[nx][ny]){
                    count ++;
                }else{
                    continue;
                }
                if(result[x][y] != 0){
                    continue;
                }
                queue.addLast(new int[] {nx,ny});
            }
            if(count == 4){
                result[x][y] = grid[x][y];
            }else{
                result[x][y] = color;
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(result[i][j] == 0){
                    result[i][j] = grid[i][j];
                }
            }
        }

        return result;
    }
}
