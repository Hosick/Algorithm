package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();    //  암호 입력받기
        br.close();
        int len = code.length();        //  암호의 길이
        long answer;

        /* (핵심!!!) 0으로 시작하는 문자라면 존재 할 수 없기 때문에 그 뒤와 상관없이 0출력 후 return */
        if (code.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        /* arr[1] ~ arr[len]까지 code 각 자리로 채우기 */
        char[] arr = new char[len + 1];
        for (int i = 1; i <= len; ++i)
            arr[i] = code.charAt(i - 1);

        /* dp 배열 선언 및 계산 */
        long[][] dp = new long[len + 1][2]; // [현재 코드의 자리 수][한 자리로 쓰이는지, 두 자리로 쓰이는지]
        dp[1][0] = 1;
        for (int i = 2; i <= len; ++i) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000; //  이전 문자가 한 자리 수로 쓰였을 때 + 두 자리 수로 쓰였을 때

            if (arr[i] == '0')   //  i번째 문자가 0이라면 혼자 쓰일 수는 없으므로 dp[i][0]을 0으로 초기화
                dp[i][0] = 0;

            int temp = Integer.parseInt(String.valueOf(arr[i - 1])) * 10 + Integer.parseInt(String.valueOf(arr[i])); //  이전 수와 합친 정수 만들기
            if (10 <= temp && temp <= 26)   //  만든 정수로 두자리 수 암호를 만들 수 있다면
                dp[i][1] = dp[i - 1][0] % 1000000;    //  i-1 문자가 한자리 수로 쓰였을 때와 같다
        }

        /* 1000000으로 나눈 나머지 출력 */
        answer = (dp[len][0] % 1000000) + (dp[len][1] % 1000000);
        System.out.println(answer % 1000000);
    }
}
