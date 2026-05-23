class Solution {
    public boolean isAnagram(String s, String t) {
          if(s.length() != t.length()){
            return false;
          }
          s = s.toLowerCase();
          t = t.toLowerCase();
          int[] ch=new int[26];
          
          for(int i=0;i<s.length();i++){
               ch[s.charAt(i)-'a']++;
               ch[t.charAt(i)-'a']--;
          }
          for(int count:ch){
            if(count != 0){
                return false;
            }
          }
          return true;
    }
}
