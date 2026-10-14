class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1; // i = 0, j = 3
        while(i < matrix.length && j >= 0) {
            if(target == matrix[i][j]) { // 13 == 10 no 
                return true;
            } else if(target > matrix[i][j]) { //10 >  13 yes i = 1 j = 3 
                i++;
            } else {
                j--; // 
            }
        }
        return false;
    }
}
