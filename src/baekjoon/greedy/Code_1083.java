package baekjoon.greedy;

import java.util.Scanner;

public class Code_1083 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();        //  배열의 길이
        int[] arr = new int[n];         //  배열 입력
        for (int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }
        int s = input.nextInt();        //  교환 기회

        /* 배열 원소 교환 시작 */
        int now = 0;    //  0부터 탐색
        while (s > 0) { //  기회가 없어질 때까지
            int max = arr[now]; //  바꿀 수 있는 범위 중 최대값
            int maxIdx = now;   //  바꿀 수 있는 범위 중 최대값

            if (now == (n - 1))    //  기회가 남아있지만 정렬이 완료되었다면 break
                break;

            /* 바꿀수 있는 범위에서 최대값찾기 */
            int range = (now + s > n - 1) ? n - 1 : now + s;
            for (int i = now + 1; i <= range; ++i) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIdx = i;
                }
            }

            /* max 값을 계속 왼쪽 수와 바꿔가며 now의 인덱스 까지 땡겨오기  */
            for (int i = maxIdx - 1; i >= now; --i)
                arr[i + 1] = arr[i];
            arr[now] = max;
            s -= (maxIdx - now);    //  땡기기 위해 교환한 만큼 남은 기회에서 제외

            now++;  //  now는 가능한 최대값이므로 다음인덱스 검사
        }

        /* 정렬한 배열 출력 */
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}
