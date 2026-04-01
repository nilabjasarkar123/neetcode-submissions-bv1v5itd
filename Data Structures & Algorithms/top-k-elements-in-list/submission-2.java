class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); 
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int [] {entry.getValue(), entry.getKey()});
        }
        int ans[] = new int[k];
        int i = 0;
        while(i < k){
            //System.out.println(pq.poll()[1]);
            ans[i] = pq.poll()[1];
            i++;
        }
        return ans;
    }
}
