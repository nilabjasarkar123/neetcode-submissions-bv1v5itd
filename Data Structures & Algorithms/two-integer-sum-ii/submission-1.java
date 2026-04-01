class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int i = 0, j = numbers.length-1;
        //Arrays.sort(numbers);
        while(i < j) {
            if(numbers[i] + numbers[j] == target) {
                return new int[] {i+1,j+1};
            }
            else if(numbers[i] + numbers[j] < target) {
                i++;
            }
            else j--;
        }
        return res;
    }
}
