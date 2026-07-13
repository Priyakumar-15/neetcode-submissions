class Solution {
    public int lengthOfLongestSubstring(String s) {
      int  [] freq = new int[256];
      Arrays.fill(freq,-1);
      int left=0;
      int ans=0;
      for(int right=0;right<s.length();right++){
        char ch= s.charAt(right);
        if(freq[ch] >= left){
            left=freq[ch]+1;
        }
        ans=Math.max(ans,right-left+1);
        freq[ch]=right;
      }
      return ans;
    }
}
