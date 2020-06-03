package baekjoon.DP;

import java.util.Scanner;

public class Code_1958 {
    static int maxThree(int a, int b, int c) {
        int temp = Math.max(a, b);
        temp = Math.max(temp, c);

        return temp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = " " + input.nextLine();
        String b = " " + input.nextLine();
        String c = " " + input.nextLine();
        int lenA = a.length();
        int lenB = b.length();
        int lenC = c.length();

        int[][][] lcs = new int[lenA][lenB][lenC];
        for (int i = 1; i < lenA; ++i) {
            for (int j = 1; j < lenB; ++j) {
                for (int k = 1; k < lenC; ++k) {
                    /* 세 개의 문자가 같다면 */
                    if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k)) {
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                    }
                    /* 세 개의 문자가 다르다면 */
                    else {
                        lcs[i][j][k] = Math.max(
                                maxThree(lcs[i][j - 1][k - 1], lcs[i - 1][j][k - 1], lcs[i - 1][j - 1][k]),
                                maxThree(lcs[i][j][k - 1], lcs[i][j - 1][k], lcs[i - 1][j][k])
                        );

                    }
                }
            }
        }
        System.out.println(lcs[lenA-1][lenB-1][lenC-1]);
    }
}