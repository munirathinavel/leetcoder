class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        Set<Integer> rows[] = new HashSet[N];
        Set<Integer> cols[] = new HashSet[N];
        Set<Integer> boxes[] = new HashSet[N];
        
        for(int i=0; i < N;i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }
        for(int r=0; r < N; r++) {
            for(int c=0; c < N;c++){
                int val = board[r][c];
                if(val == '.') {
                    continue;
                }
                if(rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                
                if(cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);
                int index = r/3*3 + c/3;
                if(boxes[index].contains(val)) {
                    return false;
                }
                boxes[index].add(val);
            }
        }
        return true;
    }
}