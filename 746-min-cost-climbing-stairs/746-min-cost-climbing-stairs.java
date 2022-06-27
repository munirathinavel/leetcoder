// Top-down Approach
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[] cost;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        return dp(cost.length);
    }
    
    private int dp(int i){
        if(i <= 1) {
            return 0;
        } else if(!map.containsKey(i)) {
            map.put(i, Math.min(cost[i-1] + dp(i-1), dp(i-2) + cost[i-2]));
        }
        return map.get(i);
    }
}