class Solution {
     public int knapsack(int [] nums,int n,int sum){
        int [] [] dp = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
           
                     dp[i][0]=1;
                 }
                 
                 for(int i = 1;i<n+1;i++){
                    for(int j = 0 ;j< sum+1;j++){
                        if(nums[i-1]<=j){
                            dp[i][j]= dp[i-1][j-nums[i-1]]+dp[i-1][j];
                        }else{
                        dp[i][j]=dp[i-1][j];
                        }
                    }
                 }
                 return dp[n][sum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i : nums){
            sum+=i;
        }
       
        if((sum+target)%2 != 0){
            return 0;
        }
        return knapsack(nums,nums.length,(sum+target)/2);
    }
}
// s1+s2=total
// s1-s2=diff
// 2s1=total+diff
// s1=total+diff/2;