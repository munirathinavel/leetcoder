class Solution {
    int size;
    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet(), new HashSet(), new HashSet());
    }
    
    private int backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        // Base condition at the last row
        if(row == size) {
            return 1;
        }
        int solutions = 0;
        for(int col = 0; col < size; col++) {
            int currentDiagonal = row - col;
            int currentAntiDiagonal = row + col;
            // If the queen is not placable
            if(cols.contains(col) || diagonals.contains(currentDiagonal) || antiDiagonals.contains(currentAntiDiagonal)) {
                continue;
            }
            // Add the queen to the board
            cols.add(col);
            diagonals.add(currentDiagonal);
            antiDiagonals.add(currentAntiDiagonal);
            // Move to the next row with updated board
            solutions += backtrack(row+1, cols, diagonals, antiDiagonals);
            //clean up for backtracking
            cols.remove(col);
            diagonals.remove(currentDiagonal);
            antiDiagonals.remove(currentAntiDiagonal);
        }
        return solutions;
    }
}