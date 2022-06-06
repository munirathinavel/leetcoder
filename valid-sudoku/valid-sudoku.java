class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        boolean rows[][] = new boolean[N][N];
        boolean cols[][] = new boolean[N][N];
        boolean boxes[][] = new boolean[N][N];

        for(int r=0; r < N; r++) {
            for(int c=0; c < N;c++){
                if(board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] -'1';
                int index = r/3*3 + c/3;
                if(rows[r][val] || cols[c][val] || boxes[index][val]) {
                    return false;
                }
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[index][val] = true;
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         int N = board.length;
//         Set<Character> rows[] = new HashSet[N];
//         Set<Character> cols[] = new HashSet[N];
//         Set<Character> boxes[] = new HashSet[N];
        
//         for(int i=0; i < N;i++) {
//             rows[i] = new HashSet<>();
//             cols[i] = new HashSet<>();
//             boxes[i] = new HashSet<>();
//         }
//         for(int r=0; r < N; r++) {
//             for(int c=0; c < N;c++){
//                 char val = board[r][c];
//                 if(val == '.') {
//                     continue;
//                 }
//                 if(rows[r].contains(val)) {
//                     return false;
//                 }
//                 rows[r].add(val);
                
//                 if(cols[c].contains(val)) {
//                     return false;
//                 }
//                 cols[c].add(val);
//                 int index = r/3*3 + c/3;
//                 if(boxes[index].contains(val)) {
//                     return false;
//                 }
//                 boxes[index].add(val);
//             }
//         }
//         return true;
//     }
// }