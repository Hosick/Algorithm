package baekjoon.greedy;

import java.util.Scanner;

public class Code_2431 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();                //  수열의 길이
        int[] arr = new int[n];                 //  수열
        boolean[] used = new boolean[n + 1];    //  값이 바뀌는데 이미 사용되었는지 여부 배열

        for (int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        /* 순열의 수 교체 : 값 a 가 a-1이 된다면, a-1은 a가 되어야한다 */
        for (int i = 0; i < n; ++i) {
            /* 수열의 값과 수열의 값-1이 둘다 사용되지 않았을 때 교체 */
            if (!used[arr[i]] && !used[arr[i] - 1] && arr[i] > 1) {
                used[arr[i]] = true;
                used[arr[i] - 1] = true;
                arr[i]--;
            }
            /* 수열의 값이 이미 사용되어있다면 값++ */
            else if (used[arr[i]])
                arr[i]++;
            /* 지나간다면 값은 사용불가 */
            used[arr[i]] = true;
        }

        for (int i : arr)
            System.out.print(i + " ");
    }
}
