package baekjoon_step.step14_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2108 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int sum = 0;

        int[] num = new int[n];
        for (int i = 0; i < n; ++i) {
            num[i] = input.nextInt();
            sum += num[i];
        }
        Arrays.sort(num);

        /*산술 평균 계산*/
        int arithmeticMean = Math.round((float)sum / n);

        /*중앙 값 계산*/
        int median;
        if (num.length % 2 == 1)
            median = num[num.length / 2];
        else
            median = (num[num.length / 2] + num[num.length / 2 - 1]) / 2;

        /*최빈 값 계산*/
        int mode = 0;
        int[] freq = new int[8001];
        int most = 0;
        for (int i = 0; i < n; ++i) {
            if (++freq[num[i] + 4000] > most)
                most = freq[num[i] + 4000];
        }
        int mostCount = 0;
        boolean isFirst = true;
        for (int i = 0; i <= 8000; ++i) {
            if (freq[i] == most) {
                ++mostCount;
                if (isFirst == true) {
                    mode = i - 4000;
                    isFirst = false;
                }
            }
            if (mostCount == 2) {
                mode = i - 4000;
                break;
            }
        }

        /*범위 계산*/
        int range = Math.abs(num[n - 1] - num[0]);

        /*출력*/
        System.out.println(arithmeticMean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
