package baekjoon.greedy;

import java.util.Scanner;

public class Code_2875 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int girls = input.nextInt();    //  여학생 수
        int boys = input.nextInt();     //  남학생 수
        int total = girls + boys;         //  총학생 수
        int maxTeam = 0;                //  만들 수 있는 최대 팀 수
        int internship = input.nextInt();// 인턴쉽에 참여해야하는 학생 수

        for (int i = 0; i <= boys; ++i) {     //  최대 만들 수 있는 팀의 범위 (0~남학생 수)
            if (i <= boys && (i * 2) <= girls && total >= (3 * i + internship)) {    //  여2 남1로 팀을 만든 후, 인턴쉽에 보낼 학생 수가 남으면
                maxTeam = i;                                        //  최대 팀 수 update
            }
        }
        System.out.println(maxTeam);
    }
}
