class Solution {
    class Pair{
        int first;
        int second;
        int third;
        Pair(int f,int s,int t){
            this.first=f;
            this.second=s;
            this.third=t;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<int[]>> adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                  adj.add(new ArrayList<>());
            }
            for(int [] flight:flights){
                adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
            }
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(0,src,0));//stop,node,cost
            int dist [] = new int[n];
            for(int i=0;i<n;i++){
                dist[i]=Integer.MAX_VALUE;
            }
            while(!q.isEmpty()){
                Pair cur=q.poll();
                int stop=cur.first;
                int node=cur.second;
                int cost=cur.third;
                if(stop > k)continue;
                for(int [] nei :adj.get(node)){
                       int curnei=nei[0];
                       int edw=nei[1];
                       if(cost+edw<dist[curnei]){
                            dist[curnei]=cost+edw;
                            q.add(new Pair(stop+1,curnei,cost+edw));
                       }
                }
            }
            if(dist[dst] != Integer.MAX_VALUE) return dist[dst];
            return -1;
    }
}
