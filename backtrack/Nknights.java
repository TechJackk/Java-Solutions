import java.util.*;
public class Nknights{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[][] board = new boolean[n][n];
        int knights = n;
        knights(board, 0, 0, knights);
        //System.out.println(knights(board, 0, 0, knights));
    }
    static void knights(boolean[][] board, int row, int col, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board[0].length) return;
        if(col == board[0].length){
            knights(board, row+1, 0, knights);
            return;
        }

        if(isSafe(board, row, col)){
            board[row][col] = true;
            knights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        knights(board, row, col + 1, knights);
    }
    static boolean isSafe(boolean[][] board, int row, int col){
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1]) return false;
        }
        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1]) return false;
        }
        if(isValid(board, row-1, col-2)){
            if(board[row-1][col-2]) return false;
        }
        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2]) return false;
        }
        return true;
    }
    static boolean isValid(boolean[][] board,int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length) return true;
        return false;
    }
    static void display(boolean[][] mat){
        for(boolean[] row : mat){
            for(boolean val : row){
                if(val) System.out.print("K"+ " ");
                else System.out.print("X"+ " ");
            }
            System.out.println();
        }
    }
}