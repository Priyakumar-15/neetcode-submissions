class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxleft=0;
        int maxright=0;
        int trapwater=0;
        while(left<=right){
          if(height[left] <= height[right]){
            if(height[left]>maxleft){
              maxleft=height[left];

            }else{
              trapwater+=maxleft-height[left];
            }
            left++;
          }else{
            if(height[right]>=maxright){
              maxright=height[right];

            }else{
              trapwater+=maxright-height[right];
            }
            right--;
          }
          
        }
        return trapwater;
    }
}
