class Solution {
    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int profit=0;
      for(int num : prices){
        minprice=Math.min(minprice,num);
        profit=Math.max(profit,(num-minprice));
      }
      return profit;
    }
}
