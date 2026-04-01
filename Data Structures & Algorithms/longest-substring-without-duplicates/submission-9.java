class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), size = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int i = 0;
        for(int j = 0; j < n; j++) {
            System.out.println(j + " "+ s.charAt(j));
            if(!mp.containsKey(s.charAt(j))) {
                mp.put(s.charAt(j), j);
            } else {
                i = Math.max(i, mp.get(s.charAt(j))+1);
                mp.put(s.charAt(j), j);
                System.out.println(i);
            }
            size = Math.max(j - i + 1, size);
            System.out.println("size : " + size + " i: "+ i + " j: "+j);
        }
        return size;
    }
}

/*
0 1 2 3 4 5 6
z x y z x y z
      j 
  i
z - 3
x - 1
y - 2

0 1 2 3 4 5 6
x z y z x y z
i
      j 


*/