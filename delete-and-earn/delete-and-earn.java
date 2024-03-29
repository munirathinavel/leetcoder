// Bottom-up + Iterative approach space optimized
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(num, maxNumber);
        }
        
        
        int back1 = 0;
        int back2 = 0;
        int n = points.size();
        if(maxNumber >= n + n * Math.log(n) / Math.log(2)) {
            List<Integer> elements = new ArrayList<Integer>(points.keySet());
            Collections.sort(elements);
            back1 = points.get(elements.get(0));
            for(int i = 1; i < elements.size(); i++) {
                int current = elements.get(i);
                int temp  = back1;
                if(current == elements.get(i-1) + 1) {
                    back1 = Math.max(back1, back2 + points.get(current));
                } else {
                    back1 += points.get(current);
                }
                back2 = temp;
            }
        } else {
            back1 = points.getOrDefault(1, 0);
            for(int i=2; i <= maxNumber; i++) {
                int temp = Math.max(back1, back2 + points.getOrDefault(i, 0));
                back2 = back1;
                back1 = temp;
            }
        }
        
        
        return back1;
    }
}
// Iterative approach space optimized
// class Solution {
//     Map<Integer, Integer> points = new HashMap<>();
    
//     public int deleteAndEarn(int[] nums) {
//         for(int num: nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//         }
//         List<Integer> elements = new ArrayList<Integer>(points.keySet());
//         Collections.sort(elements);
        
//         int back1 = points.get(elements.get(0));
//         int back2 = 0;
        
//         for(int i = 1; i < elements.size(); i++) {
//             int current = elements.get(i);
//             int temp  = back1;
//             if(current == elements.get(i-1) + 1) {
//                 back1 = Math.max(back1, back2 + points.get(current));
//             } else {
//                 back1 += points.get(current);
//             }
//             back2 = temp;
//         }
        
//         return back1;
//     }
// }

// Bottom-up approach space optimized
// class Solution {
//     Map<Integer, Integer> points = new HashMap<>();
    
//     public int deleteAndEarn(int[] nums) {
//         int maxNumber = 0;
//         for(int num: nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNumber = Math.max(num, maxNumber);
//         }
//         int back1 = points.getOrDefault(1, 0);
//         int back2 = 0;
        
//         for(int i = 2; i <= maxNumber; i++) {
//             int temp  = Math.max(back1, back2 + points.getOrDefault(i, 0));
//             back2 = back1;
//             back1 = temp;
//         }
        
//         return back1;
//     }
// }
// Bottom-up approach
// class Solution {
//     Map<Integer, Integer> points = new HashMap<>();
    
//     public int deleteAndEarn(int[] nums) {
//         int maxNumber = 0;
//         for(int num: nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNumber = Math.max(num, maxNumber);
//         }
//         int[] maxPoints = new int[maxNumber + 1];
//         maxPoints[1] = points.getOrDefault(1, 0);
        
//         for(int i = 2; i <= maxNumber; i++) {
//             maxPoints[i] = Math.max(maxPoints[i-1], maxPoints[i-2] + points.getOrDefault(i, 0));
//         }
        
//         return maxPoints[maxNumber];
//     }
// }


// Top-down approach
// class Solution {
//     Map<Integer, Integer> cache = new HashMap<>();
//     Map<Integer, Integer> points = new HashMap<>();
    
//     public int deleteAndEarn(int[] nums) {
//         int maxNumber = 0;
//         for(int num: nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNumber = Math.max(num, maxNumber);
//         }
//         // Function call
//         return deleteEarn(maxNumber);
//     }
    
//     private int deleteEarn(int num) {
//         // Base cases
//         if(num == 0) {
//             return 0;
//         } else if(num == 1) {
//             return points.getOrDefault(1, 0);
//         } else if(cache.containsKey(num)) {
//             return cache.get(num);
//         }
//         // Recurrence relation
//         cache.put(num, Math.max(deleteEarn(num - 1), deleteEarn(num - 2) + points.getOrDefault(num, 0)));
//         return cache.get(num);
//     }
// }