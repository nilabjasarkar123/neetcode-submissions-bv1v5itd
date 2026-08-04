class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length, m = board[0].length;

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxs = new boolean[9][9];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int box = (i/3)*3+(j/3);
                if(row[i][num] || col[j][num] || boxs[box][num]) return false;
                row[i][num] = true;
                col[j][num] = true;
                boxs[box][num] = true;
            }
        }
        return true;
    }
}
