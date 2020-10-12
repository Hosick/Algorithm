package baekjoon.baekjoon_step.step15_Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_14888 {
    public static int max = -1000000001;
    public static int min = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //  입력할 숫자의 갯수

        /*수열*/
        st = new StringTokenizer(br.readLine());
        int num[] = new int[n];
        for (int i = 0; i < n; ++i)
            num[i] = Integer.parseInt(st.nextToken());

        /*연산자의 갯수 배열*/
        st = new StringTokenizer(br.readLine());
        int[] operator = new int[4];
        for (int i = 0; i < 4; ++i)
            operator[i] = Integer.parseInt(st.nextToken());

        calc(num[0], 1, n, num, operator); //  정답 / 재귀 깊이 /  수열 내 수의 갯수 / 수열 배열 / 연산자 갯수 배열
        System.out.print(max + "\n" + min);
    }

    private static void calc(int answer, int deep, int n, int[] num, int[] operator) {
        /*남아 있는 연산자가 없다면 최소,최댓값과 비교후 return*/
        if (operator[0] + operator[1] + operator[2] + operator[3] == 0) {
            if (answer > max) max = answer;
            if (answer < min) min = answer;
            return;
        }

        if (operator[0] != 0) { //  더하기 연산
            --operator[0];
            calc(answer + num[deep], ++deep, n, num, operator);
            ++operator[0];
            --deep;
        }
        if (operator[1] != 0) { //  빼기 연산
            --operator[1];
            calc(answer - num[deep], ++deep, n, num, operator);
            ++operator[1];
            --deep;
        }
        if (operator[2] != 0) { //  곱하기 연산
            --operator[2];
            calc(answer * num[deep], ++deep, n, num, operator);
            ++operator[2];
            --deep;
        }
        if (operator[3] != 0) { //  나누기 연산
            --operator[3];
            calc(answer / num[deep], ++deep, n, num, operator);
            ++operator[3];
            --deep;
        }
    }
}