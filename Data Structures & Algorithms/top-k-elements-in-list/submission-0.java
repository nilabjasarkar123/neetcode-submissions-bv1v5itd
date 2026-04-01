class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Hashmap put 
        //sort it by frequency -> find top k
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x : nums) mp.put(x, mp.getOrDefault(x, 0)+1);
        List<Integer> sortedList = new ArrayList<>(mp.keySet());
        sortedList.sort((a,b)->mp.get(b)-mp.get(a));
        int ans[] = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = sortedList.get(i);
        }
        return ans;
    }
}
