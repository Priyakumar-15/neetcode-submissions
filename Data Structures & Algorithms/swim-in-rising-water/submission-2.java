class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][] vis = new int[n][m];
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int [] dr={-1,0,+1,0};
        int [] dc={0,-1,0,+1};
        pq.add(new int []{grid[0][0],0,0});
        
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            int tim=cur[0];
            int r=cur[1];
            int c=cur[2];
            if(r == n-1 && c == m-1){
                return tim;
            }
            if(vis[r][c] == 1) continue;
            vis[r][c] = 1;

            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol] ==0){
                    
                    int maxtimetillnow=Math.max(tim,grid[nrow][ncol]);
                    pq.add(new int [] {maxtimetillnow,nrow,ncol});
  
                }
            }
        }
        return -1;
    }
}
