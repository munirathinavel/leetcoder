// Binary Search
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for(int i =1; i < nums.length; i++) {
            int num = nums[i];
            if(num > sub.get(sub.size() -1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0, right = sub.size() - 1;
        
        while(left < right) {
           int mid = (left + right ) / 2;
            if(num == sub.get(mid)) {
                return mid;
            }
            if(sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

// Dynamic Progamming O(n^2)
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp,1);
        
//         for(int i =0; i < nums.length; i++) {
//             for(int j = 0; j < i; j++) {
//                 if(nums[i] > nums[j]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//         }
        
//         int longest = 0;
//         for(int count:dp) {
//             longest = Math.max(longest, count);
//         }
//         return longest;
//     }
// }