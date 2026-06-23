class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length == 0){
        return 0;
      }
      Set<Integer> set= new HashSet<>();
      for(int i:nums){
        set.add(i);
      }
        int longest=1;
        for(int i:nums){
          if(!set.contains(i-1)){
            int x=i;
            int cnt=1;
            while(set.contains(x+1)){
                 cnt++;
                 x++;
            }
            longest=Math.max(longest,cnt);
          }
        }
        return longest;
    }
}
