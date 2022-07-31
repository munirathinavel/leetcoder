class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int price:prices) {
            if(min > price) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }
}