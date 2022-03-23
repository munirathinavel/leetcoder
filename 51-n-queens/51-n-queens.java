class Solution {
    List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(board, 0, new HashSet(), new HashSet(), new HashSet());
        return solutions;
    }
    
    private void backTrack(char[][] board, int row, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals, HashSet<Integer> cols) {
        // Base condition
        if(row == board.length) {
            //Add strings to list & return the final result
            addStringToList(board);
            return;
        }
        
        for(int col = 0; col < board.length; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if(cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }
            // Place Queen to the board
            board[row][col] = 'Q';
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            backTrack(board, row + 1, diagonals, antiDiagonals, cols);
            // Roll back the changes made recently
            board[row][col] = '.';
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }
        return;
    }
    private void addStringToList(char[][] board) {
        List<String> solution = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        solutions.add(solution);
    }
}

// String concatenation
// class Solution {
//     List<List<String>> solutions = new ArrayList<>();
//     public List<List<String>> solveNQueens(int n) {
//         backTrack(new int[n][n], 0, new HashSet(), new HashSet(), new HashSet());
//         return solutions;
//     }
    
//     private void backTrack(int[][] board, int row, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals, HashSet<Integer> cols) {
//         // Base condition
//         if(row == board.length) {
//             //Add strings to list & return the final result
//             addStringToList(board);
//             return;
//         }
        
//         for(int col = 0; col < board.length; col++) {
//             int currDiagonal = row - col;
//             int currAntiDiagonal = row + col;
//             if(cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
//                 continue;
//             }
//             // Place Queen to the board
//             board[row][col] = 1;
//             cols.add(col);
//             diagonals.add(currDiagonal);
//             antiDiagonals.add(currAntiDiagonal);
//             backTrack(board, row + 1, diagonals, antiDiagonals, cols);
//             // Roll back the changes made recently
//             board[row][col] = 0;
//             cols.remove(col);
//             diagonals.remove(currDiagonal);
//             antiDiagonals.remove(currAntiDiagonal);
//         }
//         return;
//     }
//     private void addStringToList(int[][] board) {
//         List<String> solution = new ArrayList<>();
//         for(int i = 0; i < board.length; i++) {
//             String s = "";
//             for(int j = 0; j < board.length; j++) {
//                 if(board[i][j] == 1) {
//                    s += "Q"; 
//                 } else {
//                     s += ".";
//                 }
//             }
//             solution.add(s);
//         }
//         solutions.add(solution);
//     }
// }