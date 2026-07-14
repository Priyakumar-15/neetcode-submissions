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
    public int orangesRotting(int[][] grid) {
        int time=0;
        int cntone=0;
        int n= grid.length;;
        int m=grid[0].length;
        int [][] vis=new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                 }else if(grid[i][j] == 1){
                    cntone++;
                 }
                
            }
        }
        int cntrotten=0;
       int [] dr ={-1,0,+1,0};
        int [] dc = {0,-1,0,+1};
        while(!q.isEmpty()){
             Pair p=q.poll();
             int ro=p.r;
             int co=p.c;
             int step=p.steps;
             time=step;
             for(int k=0;k<4;k++){
                int nrow=ro+dr[k];
                int ncol=co+dc[k];
                if(nrow>=0 && ncol>=0 && ncol < m && nrow < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,step+1));
                    cntrotten++;
                }
             }
        }
        if(cntone != cntrotten) return -1;
        return time;
    }
}
