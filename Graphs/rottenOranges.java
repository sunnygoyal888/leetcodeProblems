// Question link -> https://leetcode.com/problems/rotting-oranges/description/

// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1

// Approach -> Using BFS | TC - O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minutes = 0;
        int fresh = 0;
        Queue<Pair> rotten = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    rotten.add(new Pair(i, j));
                }
            }
        }
        if(fresh == 0)  return 0;

        while(rotten.size() > 0){
            int size = rotten.size();
            minutes++;
            for(int i = 0; i < size; i++){
                Pair p = rotten.poll();
                int r = p.row;
                int c = p.col;
                if(r-1 >= 0 && grid[r-1][c] == 1){
                    rotten.add(new Pair(r-1, c));
                    grid[r-1][c] = 2;
                    fresh--;
                }
                if(c-1 >= 0 && grid[r][c-1] == 1){
                    rotten.add(new Pair(r, c-1));
                    grid[r][c-1] = 2;
                    fresh--;
                }
                if(r+1 < m && grid[r+1][c] == 1){
                    rotten.add(new Pair(r+1, c));
                    grid[r+1][c] = 2;
                    fresh--;
                }
                if(c+1 < n && grid[r][c+1] == 1){
                    rotten.add(new Pair(r, c+1));
                    grid[r][c+1] = 2;
                    fresh--;
                }
            }
        }

        return fresh == 0 ? minutes-1 : -1;
    }
}

class Pair {
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}


/*
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0 
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                        //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}
*/
