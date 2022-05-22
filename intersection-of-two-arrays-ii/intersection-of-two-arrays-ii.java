class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int k = 0;
        List<Integer> res = new ArrayList<>();
        for(int num:nums2) {
            int count = countMap.getOrDefault(num,0);
            if(count > 0) {
                res.add(num);
                nums1[k++] = num;
                countMap.put(num, count -1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}