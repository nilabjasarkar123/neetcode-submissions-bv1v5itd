class Solution {
public:
    
    bool isValidSudoku(vector<vector<char>>& board) {
        
        set<string> st;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                string num = to_string(board[i][j]);
                string first = num+"row"+to_string(i);
                string second = num+"col"+to_string(j);
                string third = num+"subgrid"+to_string(i/3) + to_string(j/3);
                
                if(st.find(first) != st.end() or 
                       st.find(second)!= st.end() or 
                       st.find(third) != st.end()){
                    
                    return false;
                }
                st.insert(first);
                st.insert(second);
                st.insert(third);
                
            }
        }
        return true;
    }
};
