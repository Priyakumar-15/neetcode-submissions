class Solution {
    public int trap(int[] height) {
        int trapwater=0;
        int maxleft=0;
        int maxright=0;
        int left=0;
        int right=height.length-1;
        while(left<=right){
           if(height[left] <= height[right]){
             maxleft=Math.max(maxleft,height[left]);
             trapwater+=(maxleft-height[left]);
             left++;
           }else{
             maxright=Math.max(maxright,height[right]);
             trapwater+=(maxright-height[right]);
             right--;
           }
        }
        return trapwater;
    }
}
