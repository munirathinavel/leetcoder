class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<Integer>();
        for(int val: nums1) {
            s1.add(val);
        }
        Set<Integer> s2 = new HashSet<>();
        for(int val: nums2) {
            s2.add(val);
        }
        
        s1.retainAll(s2);
        int[] res = new int[s1.size()];
        int i =0;
        for(int val:s1) {
            res[i++] = val;
        }
        return res;
    }
}