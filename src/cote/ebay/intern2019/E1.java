package cote.ebay.intern2019;

class E1 {
    public int solution(int[] prices) {
        int answer = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; ++i) {
            answer = Math.max(answer, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }

        return answer;
    }
}