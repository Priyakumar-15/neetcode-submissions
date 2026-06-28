class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st= new Stack<>();
        int area=0;
        for(int i=0;i<=heights.length;i++){
            while(!st.isEmpty() && (i==heights.length || heights[st.peek()]>heights[i])){
               int index=st.pop();
                int width;
                if(st.isEmpty()){
                    width=i;
                }else{
                    width=i-st.peek()-1;
                }
                area=Math.max(area,width*heights[index]);
            }
            if(i<heights.length){
            st.push(i);
            }
        }
        return area;
    }
}
