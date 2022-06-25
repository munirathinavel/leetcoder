// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         for(int r =0; r < matrix.length; r++) {
//             for(int c = 0; c < matrix[r].length; c++) {
//                 pq.add(matrix[r][c]);
//                 if(pq.size() > k) {
//                     pq.poll();
//                 }
//             }
//         }
//         return pq.poll();
//     }
// }


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int i =0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for(int i =0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.r == matrix.length-1) {
                continue;
            }
            pq.offer(new Tuple(t.r+1, t.c, matrix[t.r+1][t.c]));
        }
        return pq.poll().val;
    }
    
    class Tuple implements Comparable<Tuple> {
        int r;
        int c;
        int val;

        public Tuple(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple obj) {
            return this.val - obj.val; 
        }
    }
}

