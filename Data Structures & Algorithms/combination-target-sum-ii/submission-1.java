class Solution {
    public void helper(int i,int[] nums, int target,List<Integer> curr,List<List<Integer>> ans){
        
            if(target == 0){
                ans.add(new ArrayList<>(curr));
            
                 return;
        }
        for(int idx=i;idx<nums.length;idx++){  
            if(idx>i && nums[idx] == nums[idx-1]) continue;
        if(nums[idx]<=target){
            curr.add(nums[idx]);
             helper(idx+1,nums,target-nums[idx],curr,ans);
             curr.remove(curr.size()-1);
        }else{
            break;
        }
       
        
    }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,curr,ans);
        return ans;
    }
}
