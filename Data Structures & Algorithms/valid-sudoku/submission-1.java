class Solution {
    public boolean isValidSudoku(char[][] board) {
      HashSet<String> row = new HashSet<>();
      HashSet<String> col = new HashSet<>();
      HashSet<String> grid = new HashSet<>();
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
          if( board[i][j] != '.'){
            String r=i+""+board[i][j];
            String c=j+""+board[i][j];
            String g=(i/3)+""+(j/3)+""+board[i][j];
            if(row.contains(r) || col.contains(c) || grid.contains(g)) return false;
            row.add(r);
            col.add(c);
            grid.add(g);
           }

        }
      }
      return true;
    }
}
