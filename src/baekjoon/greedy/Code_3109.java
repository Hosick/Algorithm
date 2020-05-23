/**
 * 경로삭제(파이프 회수) 부분이 있다면 시간초과가 나온다. 이유는
 * 1) 빵집 도달하는데 성공했다면 해당 경로에 진행 할 수 없기 때문이다.
 * 2) 빵집 도달하는데 실패했어도 이미 실패한 위치이기 때문에 그 위치에 다른 선이 도착해도 실패이기 때문이다.
 * 따라서 반복된 실패 경로를 계속 탐색하지않으려면 경로삭제 부분이 없어야한다.
 **/
package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Code_3109 {
    static int r;   //  지도의 행
    static int c;   //  지도의 열
    static char[][] area;   //  2차원 char 지도 배열
    static int answer = 0;  //  최대 선 개수
    static boolean isSuccess;   //  성공했는지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        /* 지도에 빈칸과 건물 입력 */
        area = new char[r + 1][c + 1];
        for (int i = 1; i <= r; ++i) {
            String line = br.readLine();
            for (int j = 1; j <= c; ++j) {
                area[i][j] = line.charAt(j - 1);
            }
        }
        br.close();

        /* 1 ~ r 행의 첫번째 열부터 순서대로 출발 */
        for (int i = 1; i <= r; ++i) {
            isSuccess = false;  //  출발하기 전 성공여부는 false로 초기화
            draw(i, 1);
        }

        System.out.println(answer);
    }

    /* 백트래킹을 이용한 파이프 설치 함수 */
    static void draw(int row, int column) {
        area[row][column] = 'p';    //  파이프 설치

        if (column == c) {  //  파이프가 빵집에 도달했다면 answer++ 후 return
            answer++;
            isSuccess = true;
            return;
        }

        /* 우측 위 탐색 */
        if (!isSuccess && row > 1 && area[row - 1][column + 1] == '.')
            draw(row - 1, column + 1);
        /* 우측 탐색 */
        if (!isSuccess && area[row][column + 1] == '.')
            draw(row, column + 1);
        /* 우측 아래 탐색 */
        if (!isSuccess && row < r && area[row + 1][column + 1] == '.')
            draw(row + 1, column + 1);
    }
}