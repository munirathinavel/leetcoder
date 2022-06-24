class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n1-n2);
        for(int num: nums) {
            // System.out.println(pq);
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
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