class Solution {
    class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findupar(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulp=findupar(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public boolean unionbyrank(int u,int v){
            int ulp_u=findupar(u);
            int ulp_v=findupar(v);
            if(ulp_u == ulp_v) return false;
            if(rank.get(ulp_v) < rank.get(ulp_u)){
                parent.set(ulp_v,ulp_u);
            }
            else if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
            }else{
                parent.set(ulp_v,ulp_u);
                int ranku=rank.get(ulp_u);
                rank.set(ulp_u,ranku+1);
            }
            return true;
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length);
        for(int [] edge : edges){
            if(!ds.unionbyrank(edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[]{0,0};
    }
}
