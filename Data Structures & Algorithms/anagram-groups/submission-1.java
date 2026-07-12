class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> ans = new ArrayList<>();
       HashMap<String,List<String>> map = new HashMap<>();
       for(String st :strs){
        char [] curr = st.toCharArray();
        Arrays.sort(curr);
        String s = new String(curr);
        map.putIfAbsent(s, new ArrayList<>());
        map.get(s).add(st);
       }
       for(List<String> it : map.values()){
        ans.add(it);
       }
       return ans;
    }
}
