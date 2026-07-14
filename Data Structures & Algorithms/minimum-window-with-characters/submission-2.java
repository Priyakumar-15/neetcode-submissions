class Solution {
    public String minWindow(String s, String t) {
       int cnt=t.length();
       int [] freq = new int[128];
       int minlen=Integer.MAX_VALUE;
       int st=0;
       for(int i=0;i<t.length();i++){
        freq[t.charAt(i)]++;
       }
       int left=0;
       for(int right=0;right<s.length();right++){
           if(freq[s.charAt(right)] > 0) cnt--;
           freq[s.charAt(right)]--;
           while(cnt == 0){
            if((right-left+1)<minlen){
                minlen=right-left+1;
                st=left;
            }
            freq[s.charAt(left)]++;
            if(freq[s.charAt(left)]>0){
                cnt++;
            }
            left++;
           }
           
       }
       return minlen == Integer.MAX_VALUE?"":s.substring(st,st+minlen);
        
    }
}
