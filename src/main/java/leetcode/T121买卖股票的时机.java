package leetcode;

public class T121买卖股票的时机 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPoint =0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[minPoint]){
                res = Math.max(res,prices[i]-prices[minPoint]);
            }else{
                minPoint=i;
            }
        }

        return  res;
    }

}
