package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2212 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  센서의 개수
        int k = input.nextInt();    //  집중국의 개수

        int max = -1000001;         //  센서 좌표의 최대값 초기화
        int min = 1000001;          //  센서 좌표의 최소값 초기화
        int distance;               //  센서 끝과 끝의 거리

        /* 센서 배열 선언 후 입력 및 정렬*/
        int[] sensor = new int[n];
        for (int i = 0; i < n; ++i) {
            sensor[i] = input.nextInt();
            max = Math.max(max, sensor[i]); //  가장 큰 좌표 찾기
            min = Math.min(min, sensor[i]); //  가장 작은 좌표 찾기
        }
        Arrays.sort(sensor);

        distance = max - min;   //  센서 사이 최대거리

        /* 집중국이 센서 개수보다 같거나 많다면 0 출력 return */
        if (k >= n) {
            System.out.println(0);
            return;
        }

        /* 센서간의 간격 배열 선언 후 입력 및 정렬 */
        int[] interval = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            interval[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(interval);

        /* 집중국이 1개있을 때는 distance 그대로, 그 후 하나 더 세워질때마다 interval 중 가장 큰 수를 뺀다 */
        int temp = n - 2;   //  가장 큰 간격의 인덱스
        for (int i = 1; i < k; ++i)
            distance -= interval[temp--];

        System.out.println(distance);
    }
}