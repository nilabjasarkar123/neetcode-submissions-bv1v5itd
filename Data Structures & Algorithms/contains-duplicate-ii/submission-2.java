class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(mp.containsKey(nums[i])) {
               if(Math.abs(mp.get(nums[i]) - i) <= k){
                return true;
               } 
               else mp.put(nums[i], i);
            }
            else {
                mp.put(nums[i], i);
               }
               //System.out.println("hello");
               //System.out.println(nums[i] +":"+mp.get(nums[i]));
        }
        return false;

    }
}

/*
nums[i] index
     1  0
     2  1
     3  2
     1 


*/