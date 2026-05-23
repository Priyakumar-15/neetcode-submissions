class Solution {
    public boolean isAnagram(String s, String t) {
         char [] ans= new char[256];
        for( char ch: s.toCharArray()){
             ans[ch]++;
        }
        for( char ch:t.toCharArray()){
             ans[ch]--;
        }
        for(char ch :ans){
            if(ch != 0) return false;
        }
        return true;
    }
}
