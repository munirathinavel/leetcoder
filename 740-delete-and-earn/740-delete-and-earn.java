class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    Map<Integer, Integer> points = new HashMap<>();
    
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(num, maxNumber);
        }
        // Function call
        return deleteEarn(maxNumber);
    }
    
    private int deleteEarn(int num) {
        // Base cases
        if(num == 0) {
            return 0;
        } else if(num == 1) {
            return points.getOrDefault(1, 0);
        } else if(cache.containsKey(num)) {
            return cache.get(num);
        }
        // Recurrence relation
        cache.put(num, Math.max(deleteEarn(num - 1), deleteEarn(num - 2) + points.getOrDefault(num, 0)));
        return cache.get(num);
    }
}