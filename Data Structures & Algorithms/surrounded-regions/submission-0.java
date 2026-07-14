class Solution {
    public void dfs(int [][] vis,char[][] board,int i,int j){
        vis[i][j]=1;
        int [] dr = {-1,0,+1,0};
        int [] dc = {0,-1,0,+1};
        for(int k=0;k<4;k++){
            int nrow=i+dr[k];
            int ncol=j+dc[k];
            if(nrow>=0 && ncol >=0 && nrow <board.length && ncol < board[0].length &&  vis[nrow][ncol]==0 && board[nrow][ncol] == 'O'){
                dfs(vis,board,nrow,ncol);
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int [][] vis= new int[n][m];

       for(int i=0;i<n;i++){
    if(board[i][0]=='O' && vis[i][0]==0)
        dfs(vis,board,i,0);

    if(board[i][m-1]=='O' && vis[i][m-1]==0)
        dfs(vis,board,i,m-1);
}
for(int j=0;j<m;j++){
    if(board[0][j]=='O' && vis[0][j]==0)
        dfs(vis,board,0,j);

    if(board[n-1][j]=='O' && vis[n-1][j]==0)
        dfs(vis,board,n-1,j);
}
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }
}
