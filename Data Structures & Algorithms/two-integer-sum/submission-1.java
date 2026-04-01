class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if(mp.containsKey(rem)) {
                return new int[]{mp.get(rem), i};
            }
            mp.put(nums[i], i);
        }
        return new int[] {};
    }
}
/*
nums = [3,4,5,6], target = 7
          i
    3 - 1
    4
*/
