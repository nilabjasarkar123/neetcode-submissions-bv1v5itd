class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        Map<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[k];
        for(int i = 0; i < nums.length; i++) {
             mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.offer(new int[] {entry.getValue(), entry.getKey()});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll()[1];
        }
        return res;
    }
}
/*
1 - 1
2 - 2
3 - 3

*/