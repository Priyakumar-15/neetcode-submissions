class Solution {

    public String encode(List<String> strs) {
      StringBuilder sb= new StringBuilder();
          for(int i=0;i<strs.size();i++){
            
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));

          }
          return sb.toString();
    }

    public List<String> decode(String str) {
           int i=0;
           List<String> res = new ArrayList<>();
           while(i<str.length()){
            int j=i;
            while(j<str.length() && str.charAt(j) != '#'){
              j++;
            }
            int len=Integer.parseInt(str.substring(i,j));
           String s=str.substring(j+1,j+1+len);
           res.add(s);
           i=j+1+len;

           }
           return res;

    }
}
