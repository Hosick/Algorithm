package baekjoon.probability;

import java.util.Scanner;

public class Code_13251 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();    //  조약돌 색상의 갯수
        int[] color = new int[M];   //  색상의 갯수만큼 갯수 배열 선언
        int total = 0;              //  조약돌의 총 갯수
        for (int i = 0; i < M; ++i) {        //  각 색상의 조약돌이 몇 개 있는지
            color[i] = input.nextInt();
            total += color[i];
        }
        int K = input.nextInt();    //  뽑을 조약돌 갯수
        double perfect = 0.0;       //  모두 같은 색상의 조약돌을 뽑을 확률

        for (int i = 0; i < color.length; ++i) {    //  한 색깔씩
            if (color[i] < K) continue;                //  i번째 색깔이 뽑으려는 갯수보다 적다면 continue
            double temp[] = new double[color[i]];
            for (int j = 0; j < color[i]; ++j) {        // i번째 색깔을 뽑을 확률을 temp배열에 넣고
                temp[j] = (double) (color[i] - j) / (total - j);
            }
            for (int k = 1; k < K; ++k) {       // 모두 곱한 값을 0에 저장
                temp[0] *= temp[k];
            }
            perfect += temp[0];     //  i번째 색깔만 K번 뽑을 확률을 더해주기
        }
        if (M == 1) perfect = 1.0;  //  색이 한가지라면 확률은 1.0
        System.out.println(perfect);
    }
}