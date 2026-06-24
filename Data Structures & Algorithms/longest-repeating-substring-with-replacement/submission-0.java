class Solution {
    public int characterReplacement(String s, int k) {
        int maxfreq=0;
        int len=0;
        int left=0;
        int freq[]=new int[26];
        for(int right=0;right<s.length();right++){
          char ch = s.charAt(right);
           freq[s.charAt(right)-'A']++;
           maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
          while((right-left+1)-maxfreq > k){
            freq[s.charAt(left)-'A']--;
            left++;

          }
          len=Math.max(len,right-left+1);
          
        }
        return len;
    }
}
