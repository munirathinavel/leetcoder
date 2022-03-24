class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList(), new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(int[] nums, ArrayList<Integer> state, boolean[] values) {
        if(state.size() == nums.length){
            res.add(new ArrayList(state));
            return;
        }
        
        for(int col = 0; col < nums.length; col++) {
            if(values[col]) continue;
            state.add(nums[col]);
            values[col] = true;
            backtrack(nums, state, values);
            state.remove(state.size() -1);
            values[col] = false;
        }
    }
}
