package programmers.number;

import java.util.Arrays;

class 최고의_집합 {
    public int[] solution(int n, int s) {
        // 자연수로 n 만큼의 배열을 모두 채울수 없는 경우
        if (n > s)
            return new int[]{-1};

        // s / n 배열의 원소들을 초기화 하고 뒤에서 부터 나머지로 1씩 채우기
        int[] answer = new int[n];
        Arrays.fill(answer, s / n);
        for (int i = n - 1; i > n - s % n - 1; --i)
            answer[i]++;

        return answer;
    }
}
