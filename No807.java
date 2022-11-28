package GitProject;

public class No807 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int i = new No807().maxIncreaseKeepingSkyline(grid);
        System.out.println(i);

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid.length; column++){
                System.out.print(grid[row][column] + " ");
            }
            System.out.println();
        }
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int result = 0;
        int[] maxRow = new int [length];
        int[] maxColumn = new int [length];
        for(int row = 0; row < length; row++){
            for(int column = 0; column < length; column++){
                maxRow[row] = Math.max(maxRow[row],grid[row][column]);
                maxColumn[column] = Math.max(maxColumn[column],grid[row][column]);
            }
        }


        for(int row = 0; row < length; row++){
            for(int column = 0; column < length; column++){
                result += Math.min(maxRow[row],maxColumn[column]) - grid[row][column];
                grid[row][column] = Math.min(maxRow[row],maxColumn[column]);
            }
        }

        return result;
    }
}
