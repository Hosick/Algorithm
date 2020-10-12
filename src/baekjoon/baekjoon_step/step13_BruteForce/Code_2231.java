package baekjoon.baekjoon_step.step13_BruteForce;

import java.util.Scanner;

public class Code_2231 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int m = 1;
        while (true) {
            if (decompositionSum(m) == n) {   //  m이 n의 생성자라면 break
                break;
            }
            if (n == m) {   //  m이 n과 같을 때까지 생성자가 없다면 m을 0으로 초기화하고 break
                m = 0;
                break;
            }
            ++m;
        }
        System.out.print(m);
    }

    private static int decompositionSum(int m) {    //  분해합 구하는 함수
        int sum = m;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        return sum;
    }
}