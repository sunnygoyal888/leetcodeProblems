// Question -> https://leetcode.com/problems/shortest-path-in-binary-matrix/

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
*/

// Approach - Using Dijkstra | TC - O(n*m) | SC - O(n*m)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        
        int[][] arr = new int[m][n];
        for(int[] d: arr){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        arr[0][0] = 0;

        int[][] dirs = new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int dist = p.dist;
            int row = p.row;
            int col = p.col;

            if(row == m-1 && col == n-1){
                return dist+1;
            }

            for(int[] dir: dirs){
                int newr = row + dir[0];
                int newc = col + dir[1];

                if(newr >= 0 && newc >= 0 && newr < m && newc < n 
                    && grid[newr][newc] == 0 
                    && dist + 1 < arr[newr][newc]){

                        arr[newr][newc] = dist + 1;
                        q.add(new Pair(dist+1, newr, newc));
                }
            }
        }

        return -1;
    }

    class Pair{
        int dist;
        int row;
        int col;

        Pair(int dist, int row, int col){
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }
}
