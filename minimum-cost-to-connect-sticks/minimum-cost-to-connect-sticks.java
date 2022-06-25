class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick: sticks) {
            pq.offer(stick);
        }
        int totalCost = 0;
        while(pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            totalCost += n1 + n2;
            pq.offer(n1+ n2);
        }
        return totalCost; 
    }
}