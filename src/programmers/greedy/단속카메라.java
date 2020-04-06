/**
 * 처음에는 차량의 진입 시점 순으로 정렬을 했지만 차량의 진출 시점으로 정렬하는게 훨씬 편했다.
 **/

package programmers.greedy;

import java.util.Arrays;

class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;                 //  설치된 카메라의 개수
        int camera = Integer.MIN_VALUE; //  카메라의 위치를 가장 왼쪽에서 시작

        /* 진출 지점이 빠른 차량 순으로 정렬 */
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] route : routes) {
            if (camera < route[0]) {    //  카메라가 i번 route 진입시점보다 전에 있다면
                camera = route[1];      //  카메라를 i번 route 진출시점에 설치하고
                answer++;               //  ++answer
            }
        }
        return answer;
    }
}