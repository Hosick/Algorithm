package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();    //  문서 입력
        String word = br.readLine();        //  문서에서 찾을 단어 입력
        int lenDoc = doc.length();     //  문서의 길이
        int lenWord = word.length();        //  단어의 길이
        br.close();


        /* 단어찾기 */
        int cnt = 0;    //  문서에서 찾은 단어 개수
        int i = 0;      //  문서의 현재 인덱스
        while (i <= (lenDoc - lenWord)) {   //  i는 1부터 (문서길이 - 단어길이)까지
            /* i부터 lenWord 만큼의 단어가 찾는 단어와 같은지 체크 */
            for (int j = 0; j < lenWord; ++j) {
                if (!(doc.charAt(i + j) == word.charAt(j))) //  찾는 단어가 아니라면 break
                    break;
                if (j == lenWord - 1) {                     //  찾는 단어가 맞다면 cnt++
                    cnt++;
                    i += (lenWord - 1);                     //  i는 단어 다음으로 넘기기
                }
            }
            i++;
        }
        System.out.println(cnt);
    }
}