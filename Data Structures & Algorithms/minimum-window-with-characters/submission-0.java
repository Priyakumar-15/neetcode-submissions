class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int freq[]=new int[256];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'A']++;
        }
        int l=0;
        int cnt=t.length();
        int minlen=Integer.MAX_VALUE;
        int st=0;
        for(int r=0;r<s.length();r++){
            
            if(freq[s.charAt(r)-'A'] > 0){
               cnt--;
            }
            freq[s.charAt(r)-'A']--;
            while(cnt == 0){
                if(r-l + 1 <minlen ){
                    minlen=r-l+1;
                    st=l;
                }
                freq[s.charAt(l)-'A']++;
                 if(freq[s.charAt(l)-'A'] > 0){
                  cnt++;
            }
            l++;
            }
        }
        return minlen == Integer.MAX_VALUE? "":s.substring(st,st+minlen);
        
    }
}
