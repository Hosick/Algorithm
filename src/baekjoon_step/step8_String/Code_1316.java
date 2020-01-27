package baekjoon_step.step8_String;


import java.util.Scanner;

public class Code_1316 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String[] word = new String[n];  //  n개의 단어 배열 생성
        int group = 0; // 그룹 단어의 갯수
        int[] alpha = new int[26];

        for (int i = 0; i < n; ++i) {
            word[i] = input.next(); //  n개의 단어 입력
            for (int j = 0; j < word[i].length(); ++j) {   // i번째를 그룹단어인가 체크
                if (j > 0 && (alpha[word[i].charAt(j) - 97] != 0) && (word[i].charAt(j) != word[i].charAt(j - 1))) {    //  두번째 자리문자부터, 알파벳이 이미 증가되어있는데, 전자리문자랑 다를경우
                    group--;    //  그룹단어가 아니라서 알파벳 감소
                    break;  //  i번째 단어 검사 중지
                }
                alpha[word[i].charAt(j) - 97]++;  //  알파벳 증가
            }
            group++;
            for (int k = 0; k < 26; ++k) {    //  다음단어 검사하기전 알파벳 배열 초기화
                alpha[k] = 0;
            }
        }
        System.out.print(group);
    }
}