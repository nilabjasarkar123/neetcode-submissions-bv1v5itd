class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String f = strs[0], l = strs[strs.length-1];
        int i = 0, j = 0;
        int size = Math.min(f.length(), l.length());
        String res = "";
        while(i < size) {
            if(f.charAt(i) == l.charAt(i)) {
                res += f.charAt(i);
            } else break;
            i++;
        }
        return res;
    }
}