class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(target, nums, true);
        if(first == -1) {
            return new int[]{-1,-1};
        }
        int second = findBound(target, nums, false);
        return new int[]{first, second};
       
    }
    
    private int findBound(int target, int[] nums, boolean isFirst) {
        int l = 0, r = nums.length -1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(nums[mid] == target) {
                if(isFirst) {
                    if(mid == l || nums[mid -1] != target) {
                        return mid;
                    }
                    r = mid -1;
                } else {
                    if(mid == r || nums[mid+1] != target) {
                        return mid;                        
                    }
                    l = mid +1;
                }
                
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}