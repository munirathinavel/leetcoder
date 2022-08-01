// Approach 2: Yet-Another Dynamic Programming
class Solution {
    public int maxProfit(int[] prices) {
        int[] mp = new int[prices.length + 2];
        
        for(int i = prices.length -1; i >= 0; i--) {
            int c1 = 0;
            // Case1 - buy & sell the stock
            for(int sell = i+1; sell < prices.length; sell++) {
                int profit = (prices[sell] - prices[i]) + mp[sell + 2];
                c1 = Math.max(profit, c1);
            }
            // Case2 - do no transaction with stock p[i]
            int c2 = mp[i + 1];

            // wrap up the two cases
            mp[i] = Math.max(c1, c2);
        }
        return mp[0];
    }
}
// Approach 1: Dynamic Programming with State Machine
// class Solution {
//     public int maxProfit(int[] prices) {
//         int sold = Integer.MIN_VALUE;
//         int held = Integer.MIN_VALUE;
//         int reset = 0;
        
//         for(int price: prices) {
//             int preSold = sold;
//             sold = held + price;
//             held = Math.max(held, reset-price);
//             reset = Math.max(reset, preSold);
//         }
//         return Math.max(sold, reset);
//     }
// }