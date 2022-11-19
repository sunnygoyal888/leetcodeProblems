// Question link - https://leetcode.com/problems/word-search/
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
// The same letter cell may not be used more than once.

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j] && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, int i, int j, int idx){
        if(idx == word.length()){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || 
           word.charAt(idx) != board[i][j] || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, idx+1) || 
           search(board, word, i+1, j, idx+1) || 
           search(board, word, i, j-1, idx+1) || 
           search(board, word, i, j+1, idx+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}

// Time Complexity - O(n*m * 4^l) where l = length of word
