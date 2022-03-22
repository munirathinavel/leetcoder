class Solution {
    public int[] sortArray(int[] nums) {
       sortArray(nums, 0, nums.length-1);
        return nums;
    }
    
    private void sortArray(int[] nums, int l, int r) {
        if(l >= r) return;
        int mid = l + (r-l) / 2;
        sortArray(nums, l, mid);
        sortArray(nums, mid+1, r);
        merge(nums, l, r);
    }
    
    private void merge(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;
        int[] temp = new int[r-l+1];
        int lc = l, rc = mid + 1, tc = 0;
        while(lc <= mid || rc <= r) {
            if(lc > mid || rc <= r && nums[lc] > nums[rc]) {
                temp[tc++] = nums[rc++];
            } else {
                temp[tc++] = nums[lc++];
            }
        }
        System.arraycopy(temp, 0, nums, l, r-l+1);
    }
   
}