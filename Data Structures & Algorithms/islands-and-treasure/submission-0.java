class Solution {
    class Pair{
        int r;
        int c;
        int steps;
        Pair(int row,int col,int s){
            r=row;
            c=col;
            steps=s;
        }
    }
    private int inf=2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 0){
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int [] dr ={-1,0,+1,0};
        int [] dc = {0,-1,0,+1};
        while(!q.isEmpty()){
             Pair p=q.poll();
             int ro=p.r;
             int co=p.c;
             int step=p.steps;
             grid[ro][co]=step;
             for(int k=0;k<4;k++){
                int nrow=ro+dr[k];
                int ncol=co+dc[k];
                if(nrow>=0 && ncol>=0 && ncol < m && nrow < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == inf){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,step+1));
                }
             }

        }
        
    }
}
