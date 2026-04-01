class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if(entry.getValue() > 1) return true;
        }
        return false;
    }
}