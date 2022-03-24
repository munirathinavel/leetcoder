class Solution {
    List<String> res = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        combine(new StringBuilder(), 0, 0);
        return res;        
    }
    
    private void combine(StringBuilder state, int open, int close) {
        if(state.length() == n * 2) {
            res.add(state.toString());
            return;
        }
        if(open < n) {
            state.append('(') ;
            combine(state, open + 1, close);
            state.deleteCharAt(state.length() -1) ;
        } 
        if(close < open) {
            state.append(')') ;
            combine(state, open, close + 1);
            state.deleteCharAt(state.length() -1) ;
        }
    }
}