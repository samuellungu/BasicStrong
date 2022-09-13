public class RatInMaze {
    public static void main(String args[]){
        int maze [][] = {{1,1,0,0},
                         {1,1,0,1},
                         {1,1,0,0},
                         {0,1,1,1}};

        
        
        int N = maze.length;
        int solution [][] = new int [N][N];
        
        if(solveTheMaze(maze, 0, 0, solution, N)){
            for(int i=0; i<N;i++ ){
                for(int j=0;j<N; j++){
                    System.out.print(" "+solution[i][j]+" ");
                }
                System.out.println(" ");
            }
        }
        else{
            System.out.println("Path is not Available");
        }
        
    }
    private static boolean solveTheMaze(int [][] maze, int x, int y, int [][] solution, int N){
        
        if(x==N-1 && y==N-1 && maze[x][y]==1){
            solution[x][y]=1;
            return true;
        }
        
        if(isSafe(maze, x, y, N)){
            solution[x][y]=1;

            if(solveTheMaze(maze, x+1, y, solution, N)){
                return true;
            }
            if(solveTheMaze(maze, x, y+1, solution, N)){
                return true;
            }
            solution[x][y]=0;
            return false;
        }
        return false;
    } 
    private static boolean isSafe(int [][]maze, int x, int y, int N){
        return (
                x>=0 && x<N 
                && 
                y>=0 && y < N 
                && 
                maze[x][y]==1);
    }   
}
