class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i =0; i < nums.length; i++) {
            int val = nums[i];
            // System.out.println(indexMap);
            if(indexMap.get(val) != null && Math.abs(i- indexMap.get(val)) <= k) {
                return  true;
            } else {
                indexMap.put(val, i);    
            }
        }
        return false;
    }
}