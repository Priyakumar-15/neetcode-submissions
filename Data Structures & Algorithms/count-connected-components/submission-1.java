class Solution {
    public void dfs(int i,List<List<Integer>> adj,int [] vis){
        vis[i]=1;
        for(int j:adj.get(i)){
               if(vis[j] == 0){
                dfs(j,adj,vis);
               }
        }
    }
    public int countComponents(int n, int[][] edges) {
           int cnt=0;
           List<List<Integer>> adj = new ArrayList<>();
           for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
           }
           for(int i=0;i<edges.length;i++){
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
           }
           int [] vis = new int[n];
           for(int i=0;i<n;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i,adj,vis);
            }
           }
           return cnt;
    }
}
