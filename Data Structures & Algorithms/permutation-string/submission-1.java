class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if(s1.length() > s2.length()){
        return false;
      }
      int [] hash = new int[256];
      for(char ch:s1.toCharArray()){
        hash[ch]++;
      }
     int cnt=s1.length();
      int i=0;
      int j=0;
      while(j<s2.length()){
        
        if(hash[s2.charAt(j)]> 0){
            cnt--;
        }
        hash[s2.charAt(j)]--;
        if(j-i+1 == s1.length() ){
            if(cnt == 0) return true;
            hash[s2.charAt(i)]++;
            if(hash[s2.charAt(i)] > 0){
                cnt++;
            }
            i++;
        }
        j++;
      }
      return false;
    }
}
