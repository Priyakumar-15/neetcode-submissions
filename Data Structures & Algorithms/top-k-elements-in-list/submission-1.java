class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> [] bucket = new ArrayList[nums.length+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key:map.keySet()){
            int freq=map.get(key);
         if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
         }
            bucket[freq].add(key);
        }
        int [] ans= new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i] != null){
               for(int num:bucket[i]){
                ans[index++]=num;
                if(index == k) return ans;
               }
            }
        }
        return ans;
    }
}
