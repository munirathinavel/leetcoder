class Solution {
    public int climbStairs(int n) {
        int[] memory = new int[n+2];
        return fib(n+1, memory);
    }
    
    int fib(int n, int[] memory) {
        if( memory[n] > 0) {
            return memory[n];
        } else if(n > 1) {
            memory[n] = fib(n-1, memory) + fib(n-2, memory);
            return memory[n];
        } else {
            return n;
        }
    }
}