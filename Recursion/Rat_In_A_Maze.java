// Similar to Flood Fill Question -> https://www.youtube.com/watch?v=R1URUB6_y2k

// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
/* 
Input: N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output: DDRDRR DRDDRR
*/

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        solve(res, m, n, 0, 0, "", visited);
        return res;
    }
    
    public static void solve(ArrayList<String> res, int[][] m, int n, int i, int j, String output, boolean[][] visited){
        if(i < 0 || j < 0 || i >= n || j >= n || m[i][j] == 0 || visited[i][j]){
            return;
        }
        if(i == n-1 && j == n-1){
            res.add(output);
            return;
        }
        
        visited[i][j] = true;
        solve(res, m, n, i+1, j, output+"D", visited);
        solve(res, m, n, i, j-1, output+"L", visited);
        solve(res, m, n, i, j+1, output+"R", visited);
        solve(res, m, n, i-1, j, output+"U", visited);
        visited[i][j] = false;
    }
}
