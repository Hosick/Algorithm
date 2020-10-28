package programmers.binarySearch;

import java.util.Arrays;

class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times); //  이분 탐색을 위한 정렬

        /* 이분 탐색 */
        long left = 1; // 최소 시간
        long right = (long)times[times.length - 1] * n; // 최대 시간
        long answer = right;
        long mid, amount;
        while (left <= right) {
            mid = (left + right) / 2;
            amount = 0;
            for (int t : times)
                amount += mid / t;

            if (amount >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}