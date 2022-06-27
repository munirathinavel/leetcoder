// Bottom-up approach - Optimized
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int next = nums[0];
        int nextPlus1 = 0; 
       for(int i = 1; i < nums.length; i++){
           int current = Math.max(next, nextPlus1 + nums[i]);
           nextPlus1 = next;
           next = current;
       }
        return next;
    }
}

// Bottom-up approach
// class Solution {
//     public int rob(int[] nums) {
//         int len = nums.length;
//         if(len == 1) {
//             return nums[0];
//         }
//         int[] dp = new int[len];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0],nums[1]);
//        for(int i = 2; i < nums.length; i++){
//            dp[i] = Math.max(dp[i-1], dp[i-2]+ nums[i]);
//        }
//         return dp[len-1];
//     }
// }


// Top-down approach
// class Solution {
//     Map<Integer,Integer> map = new HashMap<>();
//     int[] nums;
//     public int rob(int[] nums) {
//         this.nums = nums;
//         return dp(nums.length-1);
//     }
    
//     private int dp(int i) {
//         if(i == 0) {
//             return nums[0];
//         } else if(i == 1) {
//             return Math.max(nums[0], nums[1]);
//         } else if(!map.containsKey(i)) {
//             map.put(i, Math.max(dp(i-1), dp(i-2) + nums[i]));
//         }
//         return map.get(i);
//     }
// }