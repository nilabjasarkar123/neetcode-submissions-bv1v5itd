class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        boolean[][] vis = new boolean[n][m];
        while(!q.isEmpty()) {
            int size = q.size();
            int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            for(int i = 0; i < size; i++) {
                int[] front = q.poll();
                int x = front[0], y = front[1];
                vis[x][y] = true;
                for(int[] dir : dirs) {
                    int new_x = x + dir[0], new_y = y + dir[1];
                    if(new_x >= n || new_x < 0 ||
                      new_y >= m || new_y < 0 ||
                      grid[new_x][new_y] == -1 || vis[new_x][new_y]) continue;
                   // System.out.println(new_x+" "+new_y);
                    grid[new_x][new_y] = Math.min(grid[new_x][new_y], 
                                        grid[x][y]+1);
                   // System.out.println(grid[new_x][new_y] );
                   // System.out.println("--------");
                    q.offer(new int[] {new_x, new_y});
                }
            }
        }
    }
}
/*
 [ 0     1  2  3
  [INF, -1, 0, INF],
  [INF,INF,INF, -1],
  [INF, -1,INF, -1],
  [0, -1, INF, INF]
]

[{0, 2}, {3, 0} |  ]
pop 0,2
if(1,2 == INF) [1,2] = [0,2]+1= 0+1 = 1
*/
