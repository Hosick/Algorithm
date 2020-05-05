package baekjoon.DP;

import java.util.Scanner;

public class Code_2449 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  전구의 개수
        int k = input.nextInt();    //  색의 개수

        int[] bulb = new int[n + 1];    //  n개의 전구 배열 (크기는 n 이지만 인접한 같은 색상은 한개로 취급한다.
        bulb[1] = input.nextInt();      //  첫번째 전구 먼저 초기화
        int amount = 1;                 //  중복을 제외한 전구의 개수
        int temp;
        for (int i = 2; i <= n; ++i) {  //  2 ~ n의 전구 입력
            temp = input.nextInt();     //  입력받은 전구의 색상이
            if (temp != bulb[amount])   //  이전 색상과 다르다면
                bulb[++amount] = temp;  //  배열에 추가
        }

        int dp[][] = new int[amount + 1][amount + 1];   //  [시작 인덱스][끝 인덱스] 사이에 바꿔야하는 전구 개수
        for (int i = 1; i <= amount; ++i) {             //  시작인덱스( 1 ~ amount)
            for (int j = 0; j < amount; ++j) {          //  시작인덱스와 끝 인덱스의 거리( 0 ~ (amount-1))
                if(i + j > amount)  //  amount를 넘어가면 다음 i로
                    break;
                /* 거리가 0일 때*/
                if (j == 0)     // 바꿔야할 전구가 없으므로 0으로 초기화
                    dp[i][i + j] = 0;
                    /* 거리가 1일 때 */
                else if (i == 1)    //  같은 색상이라면 0, 아니라면 1
                    dp[i][i + j] = (bulb[i] == bulb[i + j]) ? 0 : 1;
                    /* i와 i+j가 같은 색상일 때 */
                else if (bulb[i] == bulb[i + j])    //  양 끝에서 한개씩 땡기고 +1
                    dp[i][i + j] = dp[i + 1][i + j - 1] + 1;
                    /* i와 i+j가 다른 색상일 때 */
                else                                //  앞에서 한칸 땡기기, 뒤에서 한칸 땡기기 중 최소값 +1
                    dp[i][i + j] = Math.min(dp[i + 1][i + j], dp[i][i + j - 1]) + 1;
            }
        }

        System.out.println(dp[5][5]);
        System.out.println(dp[1][amount]);
    }
}