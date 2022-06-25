class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            pq.add(stone);
        }
        
        while(pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int diff = Math.abs(stone1 - stone2);
            if(diff > 0) {
                pq.add(diff);
            }
        }
        if(pq.isEmpty()) {
            return 0;
        } else {
            return pq.poll();
        }
    }
}