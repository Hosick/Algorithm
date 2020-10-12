package baekjoon.baekjoon_step.step8_String;

import java.io.*;

public class Code_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine().toUpperCase(); //    문자열 입력받고 대문자 변환
        int[] alpha = new int[26]; //  26개의 알파벳의 갯수를 담는 배열
        int x = -1; //

        for (int i = 0; i < line.length(); ++i) {   //  알파벳마다 갯수 저장
            x = line.charAt(i) - 65;
            ++alpha[x];
        }

        int maxIndex = 0;   //  가장 많은 알파벳의 인덱스
        int maxValue = alpha[0];   //  가장 많은 알파벳의 개수
        int isDuple = 0;
        for (int i = 1; i < 26; ++i) {
            if (alpha[i] > maxValue) {
                maxValue = alpha[i];
                maxIndex = i;
                isDuple = 0; // 중복초기화
            } else if (alpha[i] == maxValue) {
                ++isDuple;
            }
        }
        if (isDuple != 0) {
            System.out.println("?");
        } else {
            System.out.println((char) (maxIndex + 65));
        }
        bw.flush();
    }
}