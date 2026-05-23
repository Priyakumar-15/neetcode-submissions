class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        ans[0]=-1;
        ans[1]=-1;
        for(int i=0;i<nums.length;i++){
            int moreneeded= target-nums[i];
            if(map.containsKey(moreneeded)){
                ans[0]=map.get(moreneeded);
                ans[1]=i;
                
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
