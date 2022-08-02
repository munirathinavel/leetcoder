// Approach 3: Bottom-Up, Constant Space
class Solution {
    public int numWays(int n, int k) {
        if(n == 1) return k;
        if(n == 2) return k*k;
        
        int twoPostBack = k;
        int onePostBack = k * k;
        
        for(int i = 3; i <= n; i++ ) {
            int temp = (k-1) * (twoPostBack + onePostBack);
            twoPostBack=  onePostBack;
            onePostBack = temp;
        }
        return onePostBack;
    }
}
// Approach 2: Bottom-Up Dynamic Programming (Tabulation)
// class Solution {
//     public int numWays(int n, int k) {
//         if(n == 1) return k;
//         if(n == 2) return k*k;
        
//         int dp[] = new int[n + 1];
//         dp[0] = k;
//         dp[1] = k * k;
        
//         for(int i = 2; i <= n; i++ ) {
//             dp[i] = (k-1) * (dp[i-1] + dp[i-2]);
//         }
//         return dp[n-1];
//     }
// }

// Approach 1: Top-Down Dynamic Programming (Recursion + Memoization)
// class Solution {
//     public int numWays(int n, int k) {
//         return totalWays(n, k);
//     }
    
//     Map<Integer, Integer> memo = new HashMap<>();
    
//     private int totalWays(int i, int k) {
//         if(i == 1) return k;
//         if(i == 2) return k * k;
        
//         if(memo.containsKey(i)) {
//             return memo.get(i);
//         }
        
//         memo.put(i, (k-1) * (totalWays(i-1, k) + totalWays(i-2, k)));
//         return memo.get(i);
//     }
// }