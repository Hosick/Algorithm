package baekjoon.greedy;

import java.util.Arrays;
        import java.util.Scanner;

public class Code_2437 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; ++i)
            array[i] = input.nextInt();

        Arrays.sort(array);

        int answer = 1; //  정답인 최소값은 1부터 시작
        for (int i = 0; i < n; ++i) {   //  정렬된 배열은 순차적으로
            if (answer < array[i])      //  배열의 i번째 원소의 합+1이 원소보다 작다면 break
                break;
            answer += array[i];         //  아니라면 해당 원소도 더하기
        }
        System.out.print(answer);
    }
}