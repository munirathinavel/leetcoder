class Solution {
    Integer memo[];
    public int coinChange(int[] coins, int amount) {
        this.memo = new Integer[amount + 1];
        return coinChangeHelper(coins, amount);
    }
    
    private int coinChangeHelper(int[] coins, int remaining) {
        if(remaining < 0) {
            return -1;
        } else if(remaining == 0) {
            return 0;
        }
        if(memo[remaining] != null) {
            return memo[remaining];
        }
        int minCount = Integer.MAX_VALUE;
        for(int coin: coins) {
            int count = coinChangeHelper(coins, remaining - coin);
            if(count == -1) {
                continue;
            }
            minCount = Math.min(minCount, count + 1);
        }
        memo[remaining] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[remaining];
    }
}
