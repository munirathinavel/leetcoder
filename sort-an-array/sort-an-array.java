// class Solution {
//     public int[] sortArray(int[] nums) {
//         sortArray(nums, 0, nums.length-1);
//         return nums;
//     }
    
//     private void sortArray(int[] nums, int l, int r) {
//         if(l >= r) return;
//         int mid = l + (r-l)/2;
//         sortArray(nums, l, mid);
//         sortArray(nums, mid+1, r);
//         merge(nums, l,mid, r);
//     }
    
//     private void merge(int[] nums, int l, int mid, int r) {
//         int[] temp = new int[nums.length];
//         int i = l, j = mid + 1, k =l;
//         while(i <= mid && j <= r) {
//             if(nums[i] <= nums[j]) {
//                 temp[k++] = nums[i++];
//             } else {
//                 temp[k++] = nums[j++];
//             }
//         }
//         if(i > mid) {
//             while(j <= r) {
//                 temp[k++] = nums[j++];
//             }
//         }
//         if(j > r) {
//             while(i <= mid) {
//                 temp[k++] = nums[i++];
//             }
//         }
//         for(l <= r) {
//             nums[l] = temp[l];
//             l++;
//         }
//     }
// }

// Quick Sort
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    
    private void quickSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int pivot = nums[(l+r) / 2];
        int p = partition(nums, l, r, pivot);
        quickSort(nums, l, p-1);
        quickSort(nums, p, r);
    }
    
    private int partition(int[] nums, int l, int r, int pivot) {
        while(l <= r) {
            while(nums[l] < pivot) {
                l++;
            }
            while(nums[r] > pivot) {
                r--;
            }
            if(l <= r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        return l;
    }
    
    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
   
}