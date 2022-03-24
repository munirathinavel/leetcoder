class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n, k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        combine(1, new LinkedList());
        return res;
    }
    private void combine(int row, LinkedList<Integer> state) {
        if(state.size() == k) {
            res.add(new LinkedList(state));
            return;
        }
        
        for(int i = row; i <= n; i++) {
            state.add(i);
            combine(i+1, state);
            state.removeLast();
        }
    }
}