package baekjoon_step.step10_Math2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_9020 {
    static StringTokenizer input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());

        /*골드 바흐의 수 중 최대인 5082까지의 소수 판별 boolean 배열*/
        boolean[] prime = new boolean[5082];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        /* 에라토스테네스의 체 구현 */
        for (int i = 2; i * i <= 5081; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 5081; j += i) {
                    prime[j] = false;
                }
            }
        }

        /*골드 바흐 수 출력*/
        for (int i = 0; i < t; ++i) {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int x = n / 2;
            int y = n / 2;
            while (true) {
                if (prime[x] && prime[y])   //  두 수가 골드바흐 수 이면 break
                    break;
                --x;
                ++y;
            }
            bw.write(x + " " + y + "\n");
        }
        bw.flush();
    }
}