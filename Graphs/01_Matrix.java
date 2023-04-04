// Question link -> https://leetcode.com/problems/01-matrix/description/

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
// The distance between two adjacent cells is 1.

// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

// Approach - Multisource BFS | TC - O(m*n)
// Storing all the 0's position in queue & then visit all 1's in the neighbour
class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;
    }
}

/* Approach - BFS | But TC > O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    bfs(mat, i, j, m, n);
                }
            }
        }
        return mat;
    }
    static int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public void bfs(int[][] mat, int i, int j, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(q.size() > 0){
            int[] pos = q.poll();
            for(int d = 0; d < 4; d++){
                int r = pos[0] + dirs[d][0];
                int c = pos[1] + dirs[d][1];
                if(r < 0 || c < 0 || r >= m || c >= n)  continue;
                if(mat[r][c] == 0){
                    mat[i][j] = Math.abs(r-i) + Math.abs(c-j);
                    return;
                }
                q.add(new int[]{r,c});
            }
        }
    }
}
*/
