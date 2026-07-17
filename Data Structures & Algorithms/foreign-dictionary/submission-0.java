class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> adj = new HashMap<>();
      Map<Character,Integer> indegree = new HashMap<>();
      for(String word : words){
        for(char ch:word.toCharArray()){
            adj.putIfAbsent(ch,new ArrayList<>());
            indegree.putIfAbsent(ch,0);
        }
      }
      for(int i=0;i<words.length-1;i++){
        String s1=words[i];
        String s2=words[i+1];
        if (s1.length() > s2.length() && s1.startsWith(s2))
                return "";
        int len=Math.min(s1.length(),s2.length());
        for(int j=0;j<len;j++){
            if(s1.charAt(j) != s2.charAt(j)){
                adj.get(s1.charAt(j)).add(s2.charAt(j));
                 indegree.put(s2.charAt(j), indegree.get(s2.charAt(j)) + 1);
                break;
            }
        }
      }
         Queue<Character> q = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.offer(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            char curr = q.poll();
            ans.append(curr);

            for (char next : adj.get(curr)) {

                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    q.offer(next);
                }
            }
        }

        // Step 4: Cycle detection
        if (ans.length() != indegree.size())
            return "";

        return ans.toString();
         
      }
    
}
