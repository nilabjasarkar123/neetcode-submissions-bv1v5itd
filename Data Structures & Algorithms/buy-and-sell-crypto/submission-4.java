class Solution {
    public int maxProfit(int[] prices) {
      int minTill = Integer.MAX_VALUE, profit = 0;
      for(int i = 0; i < prices.length; i++) {
        if(prices[i] < minTill) minTill = prices[i];
        profit = Math.max(prices[i] - minTill, profit);
      }
      return profit;
    }
}
