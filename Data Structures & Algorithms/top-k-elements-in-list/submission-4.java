class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i < nums.length+1; i++) {
            bucket.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey(), freq = entry.getValue();
            bucket.get(freq).add(key);
        } 
        // for(int i = 0; i < bucket.size(); i++) {
        //     System.out.print(i+" ");
        //     for(int val : bucket.get(i)) {
        //          System.out.println(val);
        //     } System.out.println();
        // }
        int j = 0;
        for(int i = bucket.size() - 1; i >= 0; i--) {
            System.out.print(i+" ");
            for(int val : bucket.get(i)) {
                res[j++] = val ;//bucket.get(i).get(l);
                if(j == k) {
                    System.out.println(Arrays.toString(res));
                    return res;
                }
            }
        }
        return res;
    }
}

/*
1-1
2-3
3-3

3->2, 3
1->1

**/
