package baekjoon_step.step13_BruteForce;

import java.util.Scanner;

public class Code_2798 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  카드의 갯수
        int m = input.nextInt();    //  최고 합계
        int[] card = new int[n];    //  n장의 카드 배열
        int answer = 0; //  정답

        for (int i = 0; i < n; ++i) {   //  카드들의 숫자 입력
            card[i] = input.nextInt();
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == j || i == k || j == k) continue;  //  같은 카드는 못집는다.
                    int bruteSum = card[i] + card[j] + card[k];
                    if (bruteSum > answer && bruteSum <= m)    //  i,j,k 번째 카드 합이 최고 합계와 더 가깝다면
                        answer = bruteSum;
                }
            }
        }
        System.out.println(answer);
    }
}
