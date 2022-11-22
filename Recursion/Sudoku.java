// Question link - https://leetcode.com/problems/sudoku-solver/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    public boolean solve(char[][] board, int row, int col){
        if(col == board[0].length){
            col = 0;
            row++;
        }
        if(row == board.length)    return true;
        
        if(board[row][col] != '.')  return solve(board, row, col+1);
        
        for(char c = '1'; c <= '9'; c++){
            if(isValid(board, row, col, c)){
                board[row][col] = c;
                if(solve(board, row, col+1))    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c){
                return false;
            }
            if(board[i][col] == c){
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
              return false;
        }
        return true;
    }
}


// Approach 1
/*
class Solution {

  public static boolean solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;

              if (solveSudoku(board))
                return true;
              else
                board[i][j] = '.';
            }
          }

          return false;
        }
      }
    }
    return true;
  }

  public static boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c)
        return false;

      if (board[row][i] == c)
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    }
    return true;
  }
*/
