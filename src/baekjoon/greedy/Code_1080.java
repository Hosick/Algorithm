package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1080 {
    static int n, m;    // 행의 개수, 열의 개수
    static int[][] arr1;    //  첫번째 2차원 배열
    static int[][] arr2;    //  두번째 2차원 배열

    /* (i,j)부터 3*3행렬 뒤집는 함수 */
    private static boolean reverse(int sy, int sx) {
        /* 범위 넘어가면 false 반환 */
        if (sy + 3 > n || sx + 3 > m)
            return false;
        /* 뒤집고 true 반환 */
        for (int i = sy; i < sy + 3; ++i) {
            for (int j = sx; j < sx + 3; ++j) {
                arr1[i][j] = 1 - arr1[i][j];
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new int[n][m];
        arr2 = new int[n][m];

        /* 행렬 2개 입력 */
        for (int arr = 0; arr < 2; ++arr) {
            for (int i = 0; i < n; ++i) {
                String line = br.readLine();
                for (int j = 0; j < m; ++j) {
                    if (arr == 0)
                        arr1[i][j] = line.charAt(j) - '0';
                    else
                        arr2[i][j] = line.charAt(j) - '0';
                }
            }
        }
        br.close();

        /* (0,0)부터 시작. arr1[i][j]와 arr2[i][j]가 다르다면 3 * 3 뒤집기 */
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                /* 두 배열의 (i,j)가 다를 때 */
                if (arr1[i][j] != arr2[i][j]) {
                    if (reverse(i, j))   //  뒤집을 수 있다면 뒤집고 count++
                        count++;
                    else {              //  뒤집을 수 없다면 -1 출력후 return
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
