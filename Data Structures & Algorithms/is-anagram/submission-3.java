class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length() != t.length()){
        return false;
      }
         int freq[]=new int[256];
         for(char ch:s.toCharArray()){
          freq[ch]++;
         }
         for(char ch:t.toCharArray()){
          freq[ch]--;
         }
         for(int i:freq){
          if(i != 0) return false;
         }
         return true;
    }
}
