/**
 * @ 케이스 정리
 * 'X'일 때
 *      마지막 인덱스라면
 *          카운트가 홀수라면       ->  -1 출력 후 종료
 *          카운트가 짝수라면       ->  폴리오미노로 덮기
 *      마지막 인덱스가 아니라면     ->  continue
 * '.'일 때
 *      카운트가 0이 라면           ->  '.' 출력
 *      카운트가 0이 아니라면
 *           카운트가 홀수라면      ->  -1 출력 후 종료
 *           카운트가 짝수라면      ->  폴로오미노로 덮기
 **/

package baekjoon.greedy;

import java.io.*;

public class Code_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String board = br.readLine();

        int len = board.length();
        int count = 0;
        /* 보드를 0~len 까지 탐색 */
        for (int i = 0; i < len; ++i) {
            /* 현재 위치가 'X'일 때 */
            if (board.charAt(i) == 'X') {
                count++;    //  카운트 증가
                /* 현재 위치가 마지막이고 */
                if (i == (len - 1)) {
                    /* 카운트가 0이 아닌 홀수라면 */
                    if (count % 2 != 0) {
                        System.out.println(-1);
                        return;
                    }
                    /* 카운트가 짝수라면 */
                    bw.write(cover(count));   //  현재까지 카운트를 cover
                    count = 0;
                }
            }
            /* 현재 위치가 '.'일 때 */
            else {
                /* 카운트가 0이 라면 */
                if (count == 0) {
                    bw.write('.');
                }
                /* 카운트가 0이 아니고 */
                else {
                    /* 카운트가 홀수라면 */
                    if (count % 2 != 0) {
                        System.out.println(-1);
                        return;
                    }
                    /* 카운트가 짝수라면 */
                    bw.write(cover(count));
                    bw.write('.');
                    count = 0;
                }
            }
        }
        br.close();
        bw.close();
    }

    /* 이어진 'X'의 개수를 받아서 덮을 폴리오미노 조합을 return  */
    public static String cover(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n / 4; ++i)
            sb.append("AAAA");
        n -= (n / 4) * 4;
        for (int i = 0; i < n / 2; ++i)
            sb.append("BB");
        return sb.toString();
    }
}