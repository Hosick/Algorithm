package programmers.number;

import java.util.Arrays;

class 숫자_게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int idxA = A.length - 1;
        // B의 가장 큰 수 부터 출격
        for (int i = B.length - 1; i >= 0; --i) {
            // 이길 수 있는 A의 수 중 가장 큰 수 찾기
            while (idxA >= 0) {
                if (A[idxA--] < B[i]) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}