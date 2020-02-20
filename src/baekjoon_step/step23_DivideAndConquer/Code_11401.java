package baekjoon_step.step23_DivideAndConquer;

import java.util.Scanner;

public class Code_11401 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        long p = 1000000007;

        //  팩토리얼 값 저장 배열
        long[] fac = new long[n + 1];
        fac[0] = 1;
        fac[1] = 1;

        /* 이항계수의 분자 부분 % p */
        for (int i = 2; i <= n; i++)
            fac[i] = i * fac[i - 1] % p;
        /* 이항계수의 분모 부분 % p */
        long dm = (fac[k] * fac[n - k]) % p;

        /* 페르마의 소정리로 푸는 법 */
        /* 페르마의 정리 : a와 p가 서로소 라면 a^(p-1) % p =1 이 성립된다   */
        /* 이항 계수에서 원자인 n!을 A로 놓고, 분모인 k!*(n-k)!을 B로 놓는다면 */
        /* 우리가 구할 값을 (AB^(-1))%P 로 볼 수 있다 */
        /* 여기서 B에 페르마의 소정리를 이용해 대입한다면 */
        /* ((A%p) * (B^(p-2)%p)) % p 로 분배법칙이 가능해진다 */
        long index = p - 2;
        long fermat = 1;

        /* 거듭 제곱하기 */
        while (index > 0) {
            if (index % 2 == 1) {
                fermat *= dm;
                fermat %= p;
            }
            dm = (dm * dm) % p;
            index /= 2;
        }

        long answer = ((fac[n] % p) * (fermat % p)) % p;
        System.out.print(answer);
    }
}