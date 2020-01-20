package baekjoon_step.step6_Array;


import java.util.Scanner;

public class Code_8958 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int c = input.nextInt();    // 케이스 갯수
        String[] cases = new String[c];     // 갯수만큼의 케이스들 배열 생성
        int[] length = new int[c];  // 각 케이스 별 길이
        int[] score = new int[c];   // 각 케이스의 점수 배열

        for (int i = 0; i < c; i++) {     // 케이스에 각각의 OX결과 입력
            cases[i] = input.next();
            length[i] = cases[i].length();
        }

        for (int i = 0; i < c; i++) {   //케이스 별로 점수 출력
            int x = 1;
            for (int j = 0; j < length[i]; j++) { // i번케이스 계산
                if (cases[i].charAt(j) == 'O') {   //O면 점수추가후 추가할 점수++
                    score[i] += x;
                    x++;
                } else {  //X면 추가할 점수=1
                    x = 1;
                }
            }
            System.out.println(score[i]);
        }
    }
}