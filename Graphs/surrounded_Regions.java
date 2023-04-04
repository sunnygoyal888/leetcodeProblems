// Question link -> https://leetcode.com/problems/surrounded-regions/description/

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Approach - DFS | TC - O(m*n)
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O'){
                        dfs(board, i, j, m, n);
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c, int m, int n){
        if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O'){
            return;
        }
        board[r][c] = '#';
        dfs(board, r-1, c, m, n);
        dfs(board, r, c+1, m, n);
        dfs(board, r+1, c, m, n);
        dfs(board, r, c-1, m, n);
    }
}

/* Appraoch - BFS | TC - O(m*n)
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O'){
                        board[i][j] = '#';
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        
        int[] dirs = {0, 1, 0, -1, 0};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i];
                int nc = c + dirs[i+1];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n || board[nr][nc] != 'O')
                    continue;
                board[r][c] = '#';
                q.add(new int[]{nr,nc});
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
*/
