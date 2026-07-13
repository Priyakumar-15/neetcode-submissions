class Solution {
     class Pair{
        int first;
        int second;
        public Pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    public int bfs(int[][] grid,int [][] vis,int i,int j){
        int area=0;
        vis[i][j]=1;
        Queue<Pair> q = new LinkedList<>();
        int [] dr={-1,0,+1,0};
        int [] dc={0,+1,0,-1};
        q.add(new Pair(i,j));
        area++;
        while(!q.isEmpty()){
                 Pair curr=q.poll();
                 int r=curr.first;
                 int c = curr.second;
                 for(int k=0;k<4;k++){
                    int nrow=r+dr[k];
                    int ncol=c+dc[k];
                    if(nrow >= 0 && ncol >=0 && nrow < grid.length && ncol <grid[0].length && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                        area++;
                    }
                 }

        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;
        int [][] vis=new int[n][m];
        int maxarea=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                   
                   int currarea = bfs(grid,vis,i,j);
                   maxarea=Math.max(maxarea,currarea);
                }
            }
        }
        return maxarea;
    }
}
