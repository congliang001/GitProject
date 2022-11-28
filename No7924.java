package GitProject;



public class No7924 {

    public static void main(String[] args) {
        boolean b = new No7924().validTicTacToe(new String[]{"X  ", "   ", "  O"});
        System.out.println(b);
    }

    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'X'){
                    countX ++;
                }
                if(board[i].charAt(j) == 'O'){
                    countO ++;
                }
            }
        }

        if(countX > countO + 1 || countX < countO){
            return false;
        }
        if(checkWin(board,'X') && countX != countO + 1){
            return false;
        }
        if(checkWin(board,'O') && countX != countO){
            return false;
        }
        if(checkWin(board,'X') && checkWin(board,'O')){
            return false;
        }

        return true;
    }

    public boolean checkWin(String[] board, char c){
        for(int i = 0; i < board.length; i++){
            if(board[i].charAt(0) == board[i].charAt(1) &&
               board[i].charAt(1) == board[i].charAt(2) &&
               board[i].charAt(2) == c){
                return true;
            }
            if(board[0].charAt(i) == board[1].charAt(i) &&
               board[1].charAt(i) == board[2].charAt(i) &&
               board[2].charAt(i) == c){
                    return true;
            }
        }

        if(board[0].charAt(0) == board[1].charAt(1) &&
           board[1].charAt(1) == board[2].charAt(2) &&
           board[2].charAt(2) == c){
                return true;
        }

        if(board[0].charAt(2) == board[1].charAt(1) &&
                board[1].charAt(1) == board[2].charAt(0) &&
                board[0].charAt(2) == c){
            return true;
        }

        return false;
    }
}
