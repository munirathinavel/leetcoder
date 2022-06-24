class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> map.get(n1) - map.get(n2));
        for(int num:map.keySet()) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] res = new int[k];
        for(int i=k-1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}