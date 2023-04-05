// Questio link -> https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

// Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
/*
Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output: 3
Explanation: Same colored islands are equal. We have 4 islands, but 2 of them are equal, So we have 3 distinct islands.
*/

// Approach - DFS | TC - O(m*n) | SC - O(m*n)
class Solution {

    int countDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    ArrayList<Integer> list = new ArrayList<>();
                    dfs(grid, visited, i, j, list, i, j);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
    
    public void dfs(int[][] grid, boolean[][] visited, int r, int c, ArrayList<Integer> list, int r0, int c0){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0){
            return;
        }
        visited[r][c] = true;
        list.add(r-r0);
        list.add(c-c0);
        dfs(grid, visited, r+1, c, list, r0, c0);
        dfs(grid, visited, r-1, c, list, r0, c0);
        dfs(grid, visited, r, c+1, list, r0, c0);
        dfs(grid, visited, r, c-1, list, r0, c0);
    }
}

/* Intuition - 
We can find the no. of islands easily but how do we find no. of Distinct islands i.e. how do we identify two islands are same?
We can store co-ordinates in a list & store that list in a set as set will return unique islands. But how to figure out if coordiantes stored in set are identical?
We can call one of the starting points a base, and subtract the base coordinates from the land’s coordinates (Cell Coordinates – Base coordinates).

Make sure to follow a particular traversal and a particular order pattern, so that list ordering remains the same for every cell.
/*
