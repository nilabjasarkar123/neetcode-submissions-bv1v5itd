class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // priority queue
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.add(new int[] {entry.getValue(), entry.getKey()});
            if(heap.size() > k) {
                heap.poll();
            }
        }
        int res[] = new int[k];
        while(k-- > 0) {
            res[k] = (heap.poll()[1]);
        }
        return res;

    }
}

/*
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

*/
