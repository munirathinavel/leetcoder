class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int maxVal = Integer.MIN_VALUE;
        for(int num:nums) {
            sum += num;
            maxVal = Math.max(maxVal, num);
        }
        int left = maxVal;
        int right = sum;
        int minLargestSplitSum = 0;
        while(left <= right) {
            // Mid is maximum sum allowed
            int maxSumAllowed =  left + (right -left) / 2;
            
            if(minSubArraysRequired(nums, maxSumAllowed) <= m) {
                right = maxSumAllowed - 1;
                minLargestSplitSum = maxSumAllowed;
            } else {
                left = maxSumAllowed + 1;
            }
        }
        return minLargestSplitSum;
    }
    
    int minSubArraysRequired(int[] nums, int maxSumAllowed) {
        int currentSum = 0;
        int splitRequired = 0;
        for(int num:nums) {
            if(currentSum + num <= maxSumAllowed) {
                currentSum += num;
            } else {
                splitRequired++;
                currentSum = num;
            }
        }
        return splitRequired + 1;
    }
}