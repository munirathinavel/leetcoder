class Solution {
    public int findMin(int[] nums) {
        // If the list has just one element then return that element.
        if (nums.length == 1) {
          return nums[0];
        }
        int l = 0, r = nums.length -1;
        while(l < r) {
            int mid = l + (r -l) / 2;
            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if(nums[l] < nums[mid] && nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}