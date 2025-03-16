// Question -> https://leetcode.com/problems/path-with-minimum-effort/description/

/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). 
You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
*/

// Approach - Using Dijkstra's Algorithm | PriorityQueue | TC - O(m*n*log(m*n)) | SC - O(m*n)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] distance = new int[m][n];
        for(int[] d: distance){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        pq.add(new Tuple(0, 0, 0));
        distance[0][0] = 0;

        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 

        while(!pq.isEmpty()){
            Tuple tp = pq.poll();
            int diff = tp.diff;
            int row = tp.row;
            int col = tp.col;

            if(row == m-1 && col == n-1){
                return diff;
            }

            for(int i = 0; i < 4; i++){
                int newr = row + dr[i];
                int newc = col + dc[i];

                if(newr >= 0 && newc >= 0 && newr < m && newc < n){
                    int newEffort = Math.max(Math.abs(heights[newr][newc] - heights[row][col]), diff);
                    if(newEffort < distance[newr][newc]){
                        distance[newr][newc] = newEffort;
                        pq.offer(new Tuple(newEffort, newr, newc));
                    }
                }
            }
        }

        return 0;

    }

    class Tuple{
        int diff;
        int row;
        int col;

        Tuple(int diff, int row, int col){
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
}

// Solution video -> https://www.youtube.com/watch?v=0ytpZyiZFhA
