class Solution {
    boolean canEat(int[] piles, int bananaPerHourSpeed, int h) {
        int hour = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] <= bananaPerHourSpeed) {
                hour++;
                 
            } else {
                hour += Math.ceil((double)piles[i] / bananaPerHourSpeed);
            }
        }
       
        return hour <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high =  1000000000;
        int ans = 0;
        while(low <= high) {
            int mid = (low + high) >> 1;

            if(canEat(piles, mid, h)) {
                high = mid - 1;
                ans = mid;
            } else low = mid + 1; 
        }
        return ans;
    }
}

/*
low = 1, high = 9
mid = 5
low = 1 high = 4
mid = 2
low = 1 high = 1

 
*/