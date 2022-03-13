class Solution {
    
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return climbStairs(n, memo);
    }
    
    private int climbStairs(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        } else {
            memo[n] = climbStairs(n -1, memo) +  climbStairs(n-2, memo);
            return memo[n];
        }
    }
}