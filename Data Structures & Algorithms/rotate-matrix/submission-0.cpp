class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size(), 
            m = matrix[0].size();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int row = 0, col = m-1;
        
        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < m; j++) {
                swap(matrix[j][i], matrix[j][m-i-1]);
            }
        }
        
    }
};
