package baekjoon_step.step9_Math2;

import java.util.Scanner;

public class Code_4948 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int limit = 123456 * 2;
        /*에라토스테네스의 체*/
        boolean[] prime = new boolean[limit + 1]; // 소수 여부 확인 boolean 배열
        for (int i = 2; i <= limit; ++i) prime[i] = true;         // 전부 소수로 초기화(true = 소수)

        for (int i = 2; i * i <= limit; ++i) {  //  i로 나눔(2부터 limit의 제곱근까지)
            for (int j = i * i; j <= limit; ++j) {
                if (j % i == 0) prime[j] = false;
            }
        }

        /*계산*/
        while (true) {
            int n = input.nextInt();
            if (n == 0) break;  //  0이 입력되면 break
            int count = 0; //   n+1~2n까지 중 소수 카운트

            for (int i = n + 1; i <= 2 * n; ++i)
                if (prime[i] == true) ++count;

            System.out.println(count);
        }
    }
}
