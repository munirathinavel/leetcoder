class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            // System.out.println(pq);
            if(pq.peek() == null || k > pq.size()) {
                pq.add(num);
            } else if(pq.size() == k  && num > pq.peek()) {
                pq.poll();
                pq.add(num);
            }
            
        }
        return pq.poll();
    }
}

// Priority Queue MaxHeap - store all values:

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         for(int num: nums) {
//             pq.add(num);
//         }
//         for(int i = 0; i < k -1; i++) {
//             pq.poll();
//         }
//         return pq.poll();
//     }
// }