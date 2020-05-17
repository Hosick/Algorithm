package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Code_1700 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  멀티탭 구멍의 개수 (사이즈)
        int k = input.nextInt();    //  전기 용품의 사용 횟수
        int answer = 0;

        /* 전기 용품 사용 순서 선언 및 입력 */
        int[] schedule = new int[k];
        for (int i = 0; i < k; ++i)
            schedule[i] = input.nextInt();

        ArrayList<Integer> multitap = new ArrayList<>();

        /* 순서 0번부터 (k-1)까지 하나씩 꽂아보기 */
        for (int i = 0; i < k; ++i) {
            /* 비어있는 구멍이 있을 때 */
            if (multitap.size() < n) {
                if (!multitap.contains(schedule[i])) {   //  이미 꽂혀있지 않다면 꽂기
                    multitap.add(schedule[i]);
                }
                continue;
            }

            /* 비어있는 구멍이 없고, 이미 꽂혀있을 때 */
            if (multitap.contains(schedule[i])) {
                continue;
            }

            /* 비어있는 구멍이 없고, 꽂혀있지 않을 때 */
            int tmp = 0;        //  뽑을 콘센트 0으로 초기화
            int maxLate = 0;    //  가장 늦게 사용하는 값 0으로 초기화
            for (int j = 0; j < n; j++) { //  0 ~ (n-1) 콘센트 하나씩
                int late = 0;   //  얼마나 나중에 사용하는지 (앞으로 사용하지 않는다면 가장 큼)
                for (int l = i + 1; l < k; ++l) {    //  i 이후의 사용 스케쥴
                    if (multitap.get(j) == schedule[l]) // 스케쥴에서 찾았다면 break;
                        break;
                    late++; //  못찾았다면 late++
                }
                if (late > maxLate){    //  maxLate보다 더 늦게 사용한다면 maxLate = late
                    tmp = j;
                    maxLate = late;
                }
            }
            /* 뽑고 다시 꽂기*/
            answer++;
            multitap.set(tmp, schedule[i]);
        }

        System.out.println(answer);
    }
}
