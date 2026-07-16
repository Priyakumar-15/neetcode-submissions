class Solution {
    class Pair{
          String word;
          int steps;
          Pair(String w,int s){
            this.word=w;
            this.steps=s;
          }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.word;
            int step=curr.steps;
            if(word.equals(endWord) == true) return step;
            for(int i=0;i<word.length();i++){
                char [] arr = word.toCharArray();
                for(char ch='a';ch<='z';ch++){
                   arr[i]=ch;
                   String currword= new String(arr);
                   if(set.contains(currword) == true){
                    set.remove(currword);
                    q.add(new Pair(currword,step+1));
                   }
                }
            }
        }
        return 0;
    }
}
