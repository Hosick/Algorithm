package baekjoon_step.step8_String;

import java.util.Scanner;

public class Code_10809 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String S = input.next();

        int[] alpha = new int[26];
        for (int i = 0; i < 26; i++)    //배열 -1로 초기화
            alpha[i] = -1;

        for (int i = 97; i <= 122; i++) { //아스키코드 a~z까지
            for (int j = 0; j < S.length(); j++) {  //문자열 검사
                if(S.charAt(j)==i){ // 동일 알파벳 발견하면 배열에 넣고 break
                    alpha[i-97] = j;
                    break;
                }
            }
            System.out.print(alpha[i-97]+" ");
        }
    }
}