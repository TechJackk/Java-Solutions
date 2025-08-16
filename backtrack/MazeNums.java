public class MazeNums{
    public static void main(String[] args){
        System.out.println(paths(3, 3));
        printPaths("", 3, 3);
        System.out.println();
        printPathsWithDiagonal("", 3, 3);
        boolean[][] maze = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
        };
        System.out.println();
        printPathsWithRestrictions("", maze, 0, 0);
        System.out.println();
        boolean[][] maze2 = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        System.out.println();
        System.out.println("Paths with four directions: X-diagonal");
        printPathsWithFourDirections("", maze2, 0, 0);
        System.out.println();
        int[][] path = new int[maze2.length][maze2[0].length];
        System.out.println("Paths with four directions in matrix:");
        printPathsWithFourDirectionsMatrix("", maze2, 0, 0, path, 1);
    }
    static int paths(int row, int col){
        if(row == 1 || col == 1) return 1;
        return paths(row - 1, col) + paths(row, col - 1);
    }
    static void printPaths(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.print(p + " ");
            return;
        }
        if(row > 1) printPaths((p + "D"), row - 1, col);
        if(col > 1)printPaths((p + "R"), row, col - 1);
    }
    static void printPathsWithDiagonal(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.print(p + " ");
            return;
        }
        if(row > 1) printPathsWithDiagonal((p + "V"), row - 1, col);
        if(row > 1 && col > 1) printPathsWithDiagonal( p + "D", row - 1, col - 1);
        if(col > 1)printPathsWithDiagonal((p + "H"), row, col - 1);
    }
    static void printPathsWithRestrictions(String p, boolean[][] maze ,int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.print(p + " ");
            return;
        }
        if(!maze[row][col]) return; // If the cell is blocked, return
        if(row < maze.length - 1) printPathsWithRestrictions(p + "v", maze, row + 1, col);
        if(row < maze.length - 1 && col < maze[0].length - 1) printPathsWithRestrictions(p + "D", maze, row + 1, col + 1);
        if(col <  maze[0].length - 1)printPathsWithRestrictions(p + "H", maze, row, col + 1);
    }
    static void printPathsWithFourDirections(String p, boolean[][] maze ,int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.print(p + " ");
            return;
        }
        if(!maze[row][col]) return; // If the cell is blocked, return
        maze[row][col] = false; // Mark the cell as visited
        if(row < maze.length - 1) printPathsWithFourDirections(p + "D", maze, row + 1, col);
        if(row < maze.length - 1 && col < maze[0].length - 1) printPathsWithFourDirections(p + "X", maze, row + 1, col + 1);
        if(col <  maze[0].length - 1) printPathsWithFourDirections(p + "R", maze, row, col + 1);
        if(row > 0) printPathsWithFourDirections(p + "U", maze, row - 1, col);
        if(col > 0) printPathsWithFourDirections(p + "L", maze, row, col - 1);

        maze[row][col] = true; //this is important to mark the cell as unvisited for other paths, backtracking.
    }
    static void printPathsWithFourDirectionsMatrix(String p, boolean[][] maze ,int row, int col, int[][] path, int step){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            path[row][col] = step; //last step also needs to be stored
            for(int[] arr : path){
                System.out.println(java.util.Arrays.toString(arr));
            }
            System.out.println(p + " ");
            System.out.println();
            return;
        }
        if(!maze[row][col]) return; // If the cell is blocked, return
        maze[row][col] = false; // Mark the cell as visited
        path[row][col] = step; // Store the step in the path matrix
        if(row < maze.length - 1) printPathsWithFourDirectionsMatrix(p + "D", maze, row + 1, col, path, step + 1);
        if(row < maze.length - 1 && col < maze[0].length - 1) printPathsWithFourDirectionsMatrix(p + "X", maze, row + 1, col + 1, path, step + 1);
        if(col <  maze[0].length - 1) printPathsWithFourDirectionsMatrix(p + "R", maze, row, col + 1, path, step + 1);
        if(row > 0) printPathsWithFourDirectionsMatrix(p + "U", maze, row - 1, col, path, step + 1);
        if(col > 0) printPathsWithFourDirectionsMatrix(p + "L", maze, row, col - 1, path, step + 1);

        maze[row][col] = true; //this is important to mark the cell as unvisited for other paths, backtracking.
        path[row][col] = 0; // Reset the path matrix to 0.
    }
}