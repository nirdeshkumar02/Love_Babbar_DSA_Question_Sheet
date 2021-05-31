package Arrays;

import java.util.Arrays;

public class best_time_to_buy_and_sell_Stocks {
    public static void main(String[] args){
        int prices[] = {3,2,6,5,0,3};
        int k = 2;

        // variety in best tym to buy and sell product //

        System.out.println("The overall max profit is " + " "+ overallMaxProfit(prices));
        System.out.println("The single max profit is" + " "+SinglemaxProfit(prices));
        System.out.println("The maximum profit in at most two transactions is " + " "+ twoTransactionMaxProfit(prices));
        System.out.println("The maximum profit in at most k transactions is " + " "+ kTransactionMaxProfit(prices, k));

    }

    private static int kTransactionMaxProfit(int[] prices, int k) {
        if (k==0 || prices.length == 0) return 0;
        int cost[] = new int[k];
        int profit[] = new int[k];

        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(profit, 0);

        for(int price : prices){
            for(int i= 0; i<k; i++){
                if(i == 0){
                    cost[i] = Math.min(cost[i], price);
                    profit[i] = Math.max(profit[i], price - cost[i]);
                }
                else{
                    cost[i] = Math.min(cost[i], price - profit[i-1]);
                    profit[i] = Math.max(profit[i], price - cost[i]);
                }
            }
        }

        return profit[k-1];
    }

    private static int twoTransactionMaxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int buy1 = prices[0];
        int buy2 = prices[0];
        int sell1 = 0;
        int sell2 = 0;

        for (int price:prices){
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price-buy1);

            buy2 = Math.min(buy2, price-sell1);
            sell2 = Math.max(sell2,price-buy2);
        }
        return sell2;
    }

    private static int overallMaxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    private static int SinglemaxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;

        for(int i=0 ; i<prices.length ; i++)
        {
            if(prices[i]<min) min=prices[i];
            if(prices[i]-min>max) max=prices[i]-min;

        }
        return max;
    }
}
