package GitProject;

public class No931 {

    public static void main(String[] args) {
        int[][] square = {{2,1,3},{6,5,4},{7,8,9}};
        int i = minFallingPathSum(square);
        System.out.println(i);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;

        for(int i = 1; i < length ; i++){
            for(int j = 0; j < length; j++){
                if(j == 0){
                    matrix[i][j] +=  Math.min( matrix[i - 1][j] ,  matrix[i - 1][j + 1]);
                }else if(j == length - 1){
                    matrix[i][j] +=  Math.min( matrix[i - 1][j] ,  matrix[i - 1][j - 1]);
                }else {
                    matrix[i][j] +=  Math.min(Math.min( matrix[i - 1][j] ,  matrix[i - 1][j - 1]),matrix[i - 1][j + 1]);
                }
            }
        }

        int min = matrix[length - 1][0];
        for(int i : matrix[length - 1]){
            if(min > i){
                min = i;
            }
        }
        return min;
    }
}
