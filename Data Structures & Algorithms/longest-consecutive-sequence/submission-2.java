class Solution {
    public int longestConsecutive(int[] nums) {
      if( nums.length <=1){
        return nums.length;
      }
         int longest = 1;
         HashSet<Integer>  set = new HashSet<>();
         for(int i: nums){
          set.add(i);
         }
        for(int it : nums){
          if(!set.contains(it-1)){
            int cnt=1;
            int x= it;
            while(set.contains(x+1)){
              cnt++;
              x++;
            }
            
          longest=Math.max(longest,cnt);
          
         
        }
        set.add(it);
        }
      return longest;
}
    }
      
