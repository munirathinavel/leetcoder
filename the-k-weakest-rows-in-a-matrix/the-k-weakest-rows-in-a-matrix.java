class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? b[1]-a[1] : b[0] - a[0]);
        
        for(int r =0; r < mat.length; r++) {
            int count = binarySearch(mat[r]);
            pq.add(new int[]{count, r});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] res = new int[k];
        for(int i =k-1; i >= 0; i--) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
    
    private int binarySearch(int[] nums) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            int mid = l + (r-l) / 2;
            if(nums[mid] == 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}