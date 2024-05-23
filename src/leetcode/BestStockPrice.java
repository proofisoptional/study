package leetcode;

public class BestStockPrice {
    public static int maxProfit(int[] prices) {
        int[][] matrix = new int[prices.length][prices.length];
        int temp = 0;
        for(int i = 0; i<prices.length-1; i++){
            int last_day_profit = prices[i+1] - prices[i] + temp;
            if(last_day_profit > temp){
                temp = last_day_profit;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
