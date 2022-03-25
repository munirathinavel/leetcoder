class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
    
}

// Time Exceeded.

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         return largest(heights, 0, heights.length -1);
//     }
    
//     private int largest(int[] heights, int l, int r) {
//         if(l > r) {
//             return 0;
//         }
//         int minIndex = l;
//         for(int i = l; i <=r; i++) {
//             if(heights[i] < heights[minIndex]) {
//                 minIndex = i;
//             }
//         }
//         return Math.max(heights[minIndex] * (r-l + 1), Math.max(largest(heights, l, minIndex-1), largest(heights, minIndex + 1, r)));
                        
//     }
// }