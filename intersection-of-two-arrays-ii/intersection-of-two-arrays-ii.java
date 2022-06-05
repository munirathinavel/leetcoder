class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> m1 = new HashMap<>();
        for(int num: nums1) {
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i < nums2.length; i++) {
            int val = nums2[i];
            if(m1.get(val) != null && m1.get(val) > 0) {
                res.add(val);
                m1.put(val, m1.get(val) -1);
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}