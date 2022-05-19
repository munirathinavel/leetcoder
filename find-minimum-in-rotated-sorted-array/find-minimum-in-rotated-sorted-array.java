class Solution {
    public int findMin(int[] nums) {
        int n = nums.length -1;
        if(n == 0) {
            return nums[0];
        }
        if(nums[0] < nums[n]) {
            return nums[0];
        }
        int l = 0, r = n;
        while(l <= r) {
            int mid = l + (r-l) /2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid +1];
            }
            if(nums[mid -1] > nums[mid]) {
                return nums[mid];
            }
            if(nums[0] < nums[mid]) {
                l = mid + 1; 
            } else {
                r = mid -1;
            }
        }
        return nums[l];
    }
}