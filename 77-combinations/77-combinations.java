class Solution {
    
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> state = new LinkedList<>();
        combine(n, k, 1, state);
        return res;
    }
    
    private void combine(int n, int k, int row, LinkedList<Integer> state){
        if(state.size() == k) {
            res.add(new LinkedList(state));
            return;
        }
        
        for(int i = row; i <= n; i++) {
            state.add(i);
            combine(n, k, i + 1, state);
            state.removeLast();
        }
    }
}