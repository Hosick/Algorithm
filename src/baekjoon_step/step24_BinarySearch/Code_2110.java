package baekjoon_step.step24_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  집의 개수
        int c = Integer.parseInt(st.nextToken());   //  공유기의 개수

        /* 집의 좌표 배열 입력 및 정렬 */
        int[] house = new int[n];
        for (int i = 0; i < n; ++i)
            house[i] = Integer.parseInt(br.readLine());
        Arrays.sort(house);

        /* 가장 인접한 두 공유기 사이의 최대 거리찾기 */
        int min = 1;    //  공유기 간 거리 최소
        int max = house[n - 1] - house[0];  //  공유기 간 거리 최대

        while (min <= max) {
            int mid = (min + max) / 2;

            int temp = house[0];    //  공유기가 있는 집의 좌표
            int count = 1;          //  공유기 설치 갯수
            for (int i = 1; i < n; ++i) {
                if (temp + mid > house[n - 1])  //  공유기를 더 설치할 곳이 없다면 멈추기
                    break;
                else if (house[i] - temp >= mid) {
                    count++;
                    temp = house[i];
                }
            }
            /*System.out.println(mid+"만큼 간격을 벌리면 "+ count+"개 설치 가능하다");*/

            if (count >= c)     //  최소 mid 만큼 거리를 벌렸는데 공유기가 c 개보다 더 설치되거나 같을 때
                min = mid+1;
            else if(count < c)  //  최소 mid 만큼 거리를 벌렸는데 공유기가 c 개보다 덜 설치될 때
                max = mid-1;
        }
        System.out.print(max);
    }
}
