package programmers.sort;

import java.util.Arrays;

class H_Index {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations); //  우선 배열을 정렬
        for(int i=0; i<citations.length; i++){  //  인용 수가 적은 논문부터
            int min = Math.min(citations[i], citations.length-1);   //  [논문의 인용 수]와 [배열의 개수 - i] 중 최소값
            answer = Math.max(answer, min);                         //  앞 인덱스의 min 중 최대값
        }
        return answer;
    }
}