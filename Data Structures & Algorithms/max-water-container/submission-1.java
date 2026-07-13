class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int left=0;
        int right=heights.length-1;
        int currht;
        while(left<right){
          if(heights[left] <= heights[right]){
             currht=heights[left];
             left++;
             max=Math.max(max,currht*(right-left+1));
          }else{
             currht=heights[right];
             right--;
             max=Math.max(max,currht*(right-left+1));
          }
          
        }
        return max;
    }
}
