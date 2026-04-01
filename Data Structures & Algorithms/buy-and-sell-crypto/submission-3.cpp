class Solution {
public:
    int maxProfit(vector<int>& prices) {
       int left = 0, right = 0; // left = buy right = sell
       int maxP = 0, curProfit = 0;
       while(right < prices.size()) {
            if(prices[left] >= prices[right]) {
                left = right;
                
            }
            else {
                curProfit = prices[right] - prices[left];
                maxP = max(maxP, curProfit);
                
            }
            right++;
       } 
       return maxP;
    }
};
