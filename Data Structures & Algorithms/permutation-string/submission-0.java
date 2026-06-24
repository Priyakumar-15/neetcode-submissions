class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
       int [] s1cnt=new int[26];
       int [] s2cnt=new int[26];
       for(int i=0;i<s1.length();i++){
        s1cnt[s1.charAt(i)-'a']++;
        s2cnt[s2.charAt(i)-'a']++;
       }
       int match=0;
       for(int i=0;i<26;i++){
          if(s1cnt[i] == s2cnt[i]) match++;
       }
       int l=0;
       for(int r=s1.length();r<s2.length();r++){
        if( match == 26) return true;
        int index=s2.charAt(r)-'a';
         s2cnt[index]++;
            if (s1cnt[index] == s2cnt[index]) {
                match++;
            } else if (s1cnt[index] + 1 == s2cnt[index]) {
                match--;
            }

            index = s2.charAt(l) - 'a';
            s2cnt[index]--;
            if (s1cnt[index] == s2cnt[index]) {
                match++;
            } else if (s1cnt[index] - 1 == s2cnt[index]) {
                match--;
            }
            l++;
       }
return match == 26;
    }
}
