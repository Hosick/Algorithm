package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2865 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int people = input.nextInt();       //  예선 참가자 수
        int genre = input.nextInt();        //  장르 수
        int mainPeople = input.nextInt();   //  본선 참가자 수
        double sum = 0.0;

        double[][] ability = new double[people][genre]; // i번째 참가자의 j번 장르 능력 배열
        double[] topAbility = new double[people];       // i번 참가자의 최고 능력

        for (int i = 0; i < genre; ++i) {              //  각 장르별 참가자 능력 입력
            for (int j = 0; j < people; ++j) {
                ability[input.nextInt()-1][i] = input.nextDouble();
            }
        }

        for(int i = 0; i< people; ++i){                 //  i번 참가자의 최고 능력
            Arrays.sort(ability[i]);
            topAbility[i] = ability[i][genre-1];
        }

        Arrays.sort(topAbility);                        //  각 참가자의 최고 능력 배열을 정렬해서
        for (int i = people - 1; i >= people - mainPeople; --i) {   //  본선 참가자 수만큼만 뽑고 합계
            sum += topAbility[i];
        }

        System.out.println(String.format("%.1f",sum));  //  소숫점 첫번째자리까지 출력
    }
}