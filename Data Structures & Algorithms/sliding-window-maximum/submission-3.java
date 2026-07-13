class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int [] arr = new int[nums.length-k+1];
        int j=0;
        for(int i=0;i<nums.length;i++){
            //out of index check
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            //remove smaller from last
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            //add curr
            dq.add(i);
        
            if(i>=k-1){
                arr[j++]=nums[dq.peekFirst()];
            }
        }
        return arr;
    }
}
