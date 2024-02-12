
public class BestTimeToBuySellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] prices = {7,1,5,4,6,4};
		System.out.println(maxProfit(prices));

	}
	
	public static int maxProfit(int[] prices) {
		int lowestPrice = Integer.MAX_VALUE;
		int pist = 0; // Profit If Sold Today
		int ovrP = 0; // Overall Profit
		
		for(int i = 0; i < prices.length; i++) {
			if (prices[i] < lowestPrice) {
				lowestPrice = prices[i];
			}
			
			pist = prices[i] - lowestPrice;
			if(ovrP < pist) {
				ovrP = pist;
			}

		}
		
		return ovrP;
	}

}
