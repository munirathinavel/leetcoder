class Solution {
    int[] memo;
    public int fib(int n) {
        memo = new int[n];
        return fib(n, memo);
    }
    
    private int fib(int n, int[] memo) {
        if(n < 2) {
            return n;
        } else if(memo[n-1] > 0 ) {
            return memo[n-1];
        } else {
            int res = fib(n-1) + fib(n-2);
            memo[n-1] = res;
            return res;
        }
    }
}