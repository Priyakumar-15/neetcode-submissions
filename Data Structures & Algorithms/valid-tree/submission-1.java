class Solution {
    public void dfs(int i,List<List<Integer>> adj,int [] vis){
        vis[i]=1;
        for(int j:adj.get(i)){
               if(vis[j] == 0){
                dfs(j,adj,vis);
               }
        }
    }
    public boolean validTree(int n, int[][] edges) {
          if(edges.length != n-1) return false; // no cycle exist
          //now no cycle exits but we have to find that all nodes are connected or not
          List<List<Integer>> adj = new ArrayList<>();
          for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
          }
          for(int[] i : edges){
             adj.get(i[0]).add(i[1]);
             adj.get(i[1]).add(i[0]);
          }
          int cnt=0;
          int [] vis = new int[n];
          for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,adj,vis);
            }
          }
          if(cnt > 1) return false;
          for(int i:vis){
            if(i == 0){
                return false; // there are componenets
            }
          }
          return true;

    }
}
