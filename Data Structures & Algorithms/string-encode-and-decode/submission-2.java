class Solution {

    public String encode(List<String> strs) {
      if(strs.size() == 0)  return "";
         StringBuilder sb = new StringBuilder();
         for(int i=0;i<strs.size();i++){
          String s = strs.get(i);
          sb.append(s.length()).append("#").append(s);
         }
         return sb.toString();
    }

    public List<String> decode(String str) {
          List<String> ans = new ArrayList<>();
          if(str.isEmpty()) return ans;
          
          int i=0;
          while(i<str.length()){
            int j=i;
            while(str.charAt(j) != '#'){
                j++;
            }
            String s = str.substring(i,j);
           int len=Integer.parseInt(s);
            i=j+1;
            ans.add(str.substring(i,i+len));
           
            i=i+len;
          }
          return ans;

    }
}
