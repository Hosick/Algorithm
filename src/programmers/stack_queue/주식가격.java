package programmers.stack_queue;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];  //  정답 배열

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {    //  i의 밑으로 내려가는 구간까지
                    answer[i] = j - i;
                    break;
                } else                          //  i의 밑으로 내려가지 않는 구간까지
                    answer[i] = j - i;
            }
        }

        return answer;
    }
}