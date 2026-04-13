class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int newSize = 2*n, i = 0, k = 0;
        int[] ans = new int[newSize];
        for(i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        for(int j = i; j < newSize; j++){
            ans[j] = nums[k++];
        }
        return ans;
    }
}