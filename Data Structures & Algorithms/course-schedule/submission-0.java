class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        for(int [] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo =  new ArrayList<>();
        while(!q.isEmpty()){
            int  curr = q.poll();
            topo.add(curr);
            for(int nei:adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if(topo.size() == numCourses) return true;
        return false;
        

    }
}
