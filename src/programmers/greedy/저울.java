package programmers.greedy;

import java.util.Arrays;

class 저울 {
        public int solution(int[] weight) {
            int answer = 1; //  최소값은 1부터 시작

            Arrays.sort(weight);    //  추 들을 정렬

            for (int i = 0; i < weight.length; ++i) {
                if (weight[i] <= answer)    //  i번째 추가 최소값보다 가볍다면
                    answer += weight[i];    //  최소값에 i번 째 추를 더함
                else
                    break;  //  i번째 추가 최소값보다 무겁다면 break;
            }
            return answer;
        }
    }