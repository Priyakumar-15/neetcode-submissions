class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i=0;
        
        Arrays.sort(strs);
       
        String s=strs[0];
        String t=strs[strs.length-1];
        while(i<s.length()&& i<t.length() && s.charAt(i) == t.charAt(i)){
            
            i++;
            
        }
        return s.substring(0,i);
    }
}