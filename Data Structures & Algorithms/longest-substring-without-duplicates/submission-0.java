class Solution {
    public int lengthOfLongestSubstring(String s) {
      HashMap<Character,Integer> map = new HashMap<>();
        int len=0;
        int left=0;
        for(int right=0;right<s.length();right++){
          char ch = s.charAt(right);
           
          while(map.containsKey(ch)){
            map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
            if(map.get(s.charAt(left)) == 0){
                 map.remove(s.charAt(left));
            }
            left++;
          }
          len=Math.max(len,right-left+1);
          map.put(s.charAt(right),map.getOrDefault(ch,0)+1);
        }
        return len;
    }
}
