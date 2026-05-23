class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i=0;
        int j=0;
        Arrays.sort(strs);
        StringBuilder sb= new StringBuilder();
        String s=strs[0];
        String t=strs[strs.length-1];
        while(i<s.length()&& j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                sb.append(s.charAt(i));
            }else{
                return sb.toString();
            }
            i++;
            j++;
        }
        return sb.toString();
    }
}