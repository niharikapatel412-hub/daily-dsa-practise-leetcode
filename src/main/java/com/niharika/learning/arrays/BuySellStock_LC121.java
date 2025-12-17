package com.niharika.learning.arrays;

public class BuySellStock_LC121 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Optimal solution  " + maxProfit(prices));
        System.out.println(maxProfit(prices2));

        System.out.println("Brute force " +bruteForce(prices));
    }

    public static int maxProfit(int[] prices) {
        int minBuyPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length; i++){

            if(prices[i] < minBuyPrice){
                minBuyPrice = prices[i];
            }else{
                int profit = prices[i] - minBuyPrice;
                maxProfit= Math.max(maxProfit, profit);
            }
        }
        return maxProfit;

    }

    public  static int  bruteForce(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}

