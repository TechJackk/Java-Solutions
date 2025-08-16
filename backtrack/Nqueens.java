import java.util.*;
public class Nqueens{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[][] matrix = new boolean[n][n];
        System.out.println(nQueen(matrix, 0));
    }
    static int nQueen(boolean[][] matrix, int row){
        if(row == matrix.length){
            display(matrix);
            System.out.println();
            return 1;
        }

        int count = 0;

        for(int col = 0; col < matrix[0].length; col++){
            if(isSafe(matrix, row, col)){
                matrix[row][col] = true;
                count += nQueen(matrix, row + 1);
                matrix[row][col] = false;
            }
        }
        return count;
    }
    static boolean isSafe(boolean[][] mat, int row, int col){
        //vertical row
        for(int r = 0; r<=row; r++){
            if(mat[r][col]) return false;
        }

        //diagonal left
        int maxLeft = Math.min(row, col);
        for(int i = 1; i<=maxLeft; i++){
            if(mat[row-i][col-i]) return false;
        }

        //diagonal right
        int maxRight = Math.min(row, mat.length - col - 1);
        for(int i = 1; i<=maxRight; i++){
            if(mat[row -i][col+i]) return false;
        }

        return true;
    }
    static void display(boolean[][] mat){
        for(boolean[] row : mat){
            for(boolean val : row){
                if(val) System.out.print("Q"+ " ");
                else System.out.print("X"+ " ");
            }
            System.out.println();
        }
    }
}