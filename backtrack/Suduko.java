public class Suduko{
    public static void main(String[] args){
        int[][] board = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2 ,0 ,6 ,3 ,0 ,0}
        };
        if(solveSuduko(board)){
            display(board);
        } else {
            System.out.println("No solution");
        }
    }
    static boolean solveSuduko(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(!emptyLeft) break;
        }
        if(emptyLeft) return true; //solved

        //backtracking
        for(int i = 1; i<=9; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i; //place the number
                if(solveSuduko(board)) return true; //recurrsion
                board[row][col] = 0; //backtrack
            }
        }
        return false; //no solution found.
    }
    static boolean isSafe(int[][] board, int row, int col, int num){
        //check row
        for(int i=0; i<board.length; i++){
            if(board[row][i] == num) return false;
        }

        //check column
        for(int[] Row : board){
            if(Row[col] == num) return false;
        }

        //check 3x3 box
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
        for(int r = 0; r<sqrt; r++){
            for(int c = 0; c<sqrt; c++){
                if(board[r+boxRowStart][c+boxColStart] == num) return false;
            }
        }
        return true;
    }
    static void display(int[][] board){
        for(int[] row : board){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}