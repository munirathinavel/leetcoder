// Bottom-up approach - Optimized
class Solution {
    public int tribonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n < 3) {
            return 1;
        }
        
        int one = 0;
        int two = 1;
        int three = 1;
        for(int i = 3; i < n + 1; i++) {
            int current = three + two + one;
            one = two;
            two = three;
            three = current;
        }
        return three;
    }
}
// Bottom-up approach
// class Solution {
//     public int tribonacci(int n) {
//         if(n == 0) {
//             return 0;
//         } else if(n < 3) {
//             return 1;
//         }
        
//         int dp[] = new int[n+1];
//         dp[1] = 1;
//         dp[2] = 1;
//         for(int i = 3; i < n + 1; i++) {
//             dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
//         }
//         return dp[n];
//     }
// }