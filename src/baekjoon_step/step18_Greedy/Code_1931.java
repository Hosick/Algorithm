package baekjoon_step.step18_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Code_1931 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* 회의 갯수와 회의 시간 입력*/
        int n = input.nextInt();

        int[][] conference = new int[n][2];

        for (int i = 0; i < n; ++i) {
            conference[i][0] = input.nextInt(); //  i번 회의 시작 시간
            conference[i][1] = input.nextInt(); //  i번 회의 종료 시간
        }

        /* 회의 종료시간 내림 차순으로 회의를 정렬*/
        Arrays.sort(conference, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int now = 0;    //  회의가 끝난 지금의 시간
        int count = 0;  //  잡은 회의 갯수
        for (int i = 0; i < n; ++i) {
            if (conference[i][0] >= now) {  //  회의 진행이 가능하다면 진행
                now = conference[i][1];
                count++;
            }
        }

        System.out.print(count);
    }
}