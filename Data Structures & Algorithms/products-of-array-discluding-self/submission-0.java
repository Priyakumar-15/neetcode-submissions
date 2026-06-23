class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arr[]=new int[nums.length];
        int left=1;
        arr[0]=left;
        for(int i=1;i<nums.length;i++){
          left*=nums[i-1];
          arr[i]=left;
        }
        int right=1;
        for(int i=arr.length-2;i>=0;i--){
          right*=nums[i+1];
          arr[i]=arr[i]*right;
        }
        return arr;
    }
}  
