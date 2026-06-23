class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> freq=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
       }
       List<Integer> [] bucket=new ArrayList[nums.length+1];
       for(int i:freq.keySet()){
        int count=freq.get(i);
        if(bucket[count] == null){
          bucket[count]=new ArrayList<>();
        }
        bucket[count].add(i);
       }
       int [] ans=new int[k];
       int idx=0;
       for(int i=bucket.length-1;i>=0 && idx <k;i--){
          if(bucket[i] != null){
            for(int num:bucket[i]){
              ans[idx++]=num;
              
              if(idx == k) break;
            }
          }
       }
       return ans;
    }
}
