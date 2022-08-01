// Bottom up Approach Optimized
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int down1 = 0, down2 =0;

        for(int i =2; i< cost.length + 1; i++) {
            int temp = Math.min(cost[i-1] + down1 , cost[i-2] + down2);
            down2 = down1;
            down1 = temp;
        }
        return down1;
    }
}
// Bottom-up Approach
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int dp[] = new int[n + 1];
//         for(int i =2; i < dp.length; i++) {
//             dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
//         }
//         return dp[dp.length -1];
//     }
// }


// // Top-down Approach
// class Solution {
//     Map<Integer, Integer> map = new HashMap<>();
//     int[] cost;
//     public int minCostClimbingStairs(int[] cost) {
//         this.cost = cost;
//         return dp(cost.length);
//     }
    
//     private int dp(int i){
//         if(i <= 1) {
//             return 0;
//         } else if(!map.containsKey(i)) {
//             map.put(i, Math.min(cost[i-1] + dp(i-1), dp(i-2) + cost[i-2]));
//         }
//         return map.get(i);
//     }
// }