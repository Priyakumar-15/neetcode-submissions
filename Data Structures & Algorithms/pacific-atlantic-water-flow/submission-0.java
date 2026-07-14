class Solution {
    public void dfs(int row,int col,boolean [][] vis,int[][] ht){
        vis[row][col]=true;
        int [] dr={-1,0,+1,0};
        int [] dc={0,-1,0,+1};
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            
            if(nrow<0 || ncol <0 || nrow>=vis.length || ncol>=vis[0].length){
                continue;
            }
            if(vis[nrow][ncol]){
                continue;
            }
            if(ht[row][col]<=ht[nrow][ncol]){
            dfs(nrow,ncol,vis,ht);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean [][] pacific = new boolean [n][m];
        boolean [][] atlantic = new boolean [n][m];
        //top row for  pacific
        for(int j=0;j<m;j++){
            dfs(0,j,pacific,heights);
        }
        // left col for pacific
        for(int i=0;i<n;i++){
            dfs(i,0,pacific,heights);
        } 
        //last row for atlantic
        for(int j=0;j<m;j++){
            dfs(n-1,j,atlantic,heights);
        }
        // last col fro atlantic
        for(int i=0;i<n;i++){
            dfs(i,m-1,atlantic,heights);
        } 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;


    }
}
