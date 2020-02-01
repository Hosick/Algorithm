package baekjoon_step.step15_Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Code_15650 {
    private static int[] num = new int[10];   //  0-9까지
    private static boolean[] visit = new boolean[10];   //

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  최대 값
        int m = input.nextInt();    //  한 줄당 출력할 수

        printSeq(0, n, m);  //  출력
    }

    /*수열 출력 함수 정의*/
    private static void printSeq(int index, int n, int m) {
        if (index == m) {   //  m(한 줄 당 출력할 수)가 (배열에) 다 채워졌다면
            int[] temp = Arrays.copyOf(num, m); //  temp 배열에 num 배열복사(m까지만)
            int[] temp2 = Arrays.copyOf(num, m); //  temp 2배열에도 num 배열복사(m까지만)
            Arrays.sort(temp);  //  temp 만정렬

            if (Arrays.equals(temp, temp2)) { //  num 배열이 오른 차순으로 정렬되었을때만 출력
                for (int i = 0; i < m; ++i) {   //  배열 전부 출력 후 리턴
                    System.out.print(num[i]);
                    if (i != m - 1)
                        System.out.print(" ");
                }
                System.out.println();
                return;
            }
        }
        for (int i = 1; i <= n; ++i) {  //  1~n(최댓값)까지
            if (visit[i])   //  재귀 전에 i가 나왔다면 pass
                continue;
            visit[i] = true;    //  i를 다음 재귀에서는 pass함
            num[index] = i;   //  배열의 index번 째 수는 i
            printSeq(index + 1, n, m);  //  배열 다음 원소 구하는 재귀
            visit[i] = false;   //  한번 돌고 다시 지나갔던 흔적 지우기
        }
    }
}