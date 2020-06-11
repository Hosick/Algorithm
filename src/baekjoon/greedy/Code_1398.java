/**
 * 동전의 배열을 3개 씩 끊어보면 100을 곱한것과 같다
 * ex) 1, 10, 25 / 100, 1000, 2500 / 10000, 100000, 250000
 * 따라서 0 ~ 99까지 가격의 동전 최소 개수만 구하고 가격의 100씩을 나눠서 따로 계산해주면 된다
 **/
        package baekjoon.greedy;

import java.util.*;

public class Code_1398 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] cases = new int[100]; //  0 ~ 99까지의 필요한 동전 개수
        Arrays.fill(cases, 100);

        for (int i = 0; i < 100; ++i) {             //  필요한 돈
            for (int j = 0; (j * 25) <= i; ++j) {       //  25원으로 지불한 금액
                int mod = i - (j * 25);                   //  25원 동전을 사용하고 남은 돈
                int temp = j + (mod / 10) + (mod % 10);  //  25원동전 개수 + 10원동전 개수 + 1원동전 개수
                cases[i] = Math.min(cases[i], temp);
            }
        }

        /* 테스트 케이스 돌리기 */
        int t = input.nextInt();
        while (t-- > 0) {
            long price = input.nextLong();  //  가격
            int count = 0;                  //  동전 개수

            /* 백단위로 끊어서 계산하기 */
            while (price > 100) {
                count += cases[(int) (price % 100)];
                price /= 100;
            }
            count += cases[(int) price];

            System.out.println(count);
        }
    }
}