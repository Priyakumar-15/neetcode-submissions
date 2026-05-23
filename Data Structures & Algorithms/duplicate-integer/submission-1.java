class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set <Integer> m=new HashSet<>();
        for(int num:nums){
            if(m.contains(num)){
                return true;
            }
            m.add(num);
        }
    return false;
    }
}