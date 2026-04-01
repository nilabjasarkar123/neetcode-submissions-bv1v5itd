class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char s1arry[] = s1.toCharArray();
        Arrays.sort(s1arry);
        int right = 0;
        for(int left = 0; left <= s2.length()-s1.length(); left++) {
            char s2Array[] = new char[s1.length()];
            int i = 0; right = left;
            while(i < s1.length()) {
                s2Array[i] = s2.charAt(right);
                right++;
                i++;
            }
            Arrays.sort(s2Array);
            if(Arrays.equals(s1arry, s2Array)) return true;
        }
        return false;
    }
}
