class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] ans = new int[numCourses];
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
        int i=0;
        while(!q.isEmpty()){
            int  curr = q.poll();
            ans[i++]=curr;
            for(int nei:adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if (i != numCourses) {
            return new int[0];
        }
       
        return ans;
    }
}
