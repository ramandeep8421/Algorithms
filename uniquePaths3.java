import java.util.*;

class Solution {
    
    //variable to store the answer
    int ans = 0;

    //DIrection vector
    int[] dr = {0, 1, 0, -1, 0};
    
    //dfs function to traverse the grid
    public void dfs(int i, int j, int x, int y, int[][] grid, boolean[][] visited){

          //dimensions of the grid
          int n = grid.length, m = grid[0].length;

          //check if the current cell meets the ending cell
          if(i == x && j == y){

              //mark this cell as visited
              visited[i][j] = true;

              //check if all cells of the grid are visited or not
              if(check(grid, visited)) ans++;

              //unmark the current cell
              visited[i][j] = false;

              //return from here
              return;
          }

          //mark the visited true
          visited[i][j] = true;
          
          //move to 4 directions
          for(int k=0; k<4; k++){
               
                //move to new cell
                int newr = i + dr[k], newc = j + dr[k+1];
               
                //If the new cell is already visited or its not empty cell then continue to another cell
                if(newr < 0 || newr >= n || newc < 0 || newc >= m || grid[newr][newc] == 1 || visited[newr][newc]) continue;
                 
                //move to the new cell
                dfs(newr, j, x, y, grid, visited);
          }

          //after exploring the paths in all 4 directions 
          // unmark the current cell
          visited[i][j] = false;
    }
     
    public int uniquePathsIII(int[][] grid) {

         //find the dimensions of the grid
          int n = grid.length;
          int m = grid[0].length;
          
          //declare a visited array
          boolean[][] visited = new boolean[n][m];

          int sr=0,sc=0,er=0,ec=0;

          for(int i=0; i<n; i++){
               for(int j=0; j<m; j++){
                    if(grid[i][j] == 1){
                         sr = i;
                         sc = j;
                    }else if(grid[i][j] == 2){
                         er = i;
                         ec = j;
                    }
               }
          }

         //call the dfs function at the starting cell
         // or the top left cell
         dfs(sr, sc, er, ec, grid, visited);
        
         //return the answer from the end of the function
         return ans;
   }
    
   //helper function to check if all empty cells are visited or not
   public boolean check(int[][] grid, boolean[][] visited){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    return false;
                }
            }
        }
        return true;
   }    
}
