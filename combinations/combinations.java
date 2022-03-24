class Solution {
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(1, new ArrayList(), res, n, k);
        return res;
    }
    private void combine(int row, ArrayList<Integer> state, List<List<Integer>> res, int n, int k) {
        if(state.size() == k) {
            res.add(new ArrayList(state));
            return;
        }
        
        for(int i = row; i <= n; i++) {
            state.add(i);
            combine(i+1, state, res, n, k);
            state.remove(state.size() - 1);
        }
    }
}