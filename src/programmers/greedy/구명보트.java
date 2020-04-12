package programmers.greedy;

import java.util.Arrays;

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0; //  정답 : 필요한 배의 갯수
        Arrays.sort(people);    //  우선 사람들을 무게순으로 정렬

        int start = 0;  //  가장 가벼운 사람부터 start
        int end = people.length - 1;    //  가장 무거운 사람부터 end
        while (start < end) {
            int sum = people[end--];    //  배에는 가장 무거운 사람부터 태운 후 end--;
            if (sum + people[start] <= limit)   //  가장 가벼운 사람이 같이 탈 수 있다면
                sum += people[start++];         //  태우고 start++;
            ++answer;   //  배 한 대 추가
        }
        if (start == end)   //  만약 한사람이 남는다면
            ++answer;       //  배 한 대 추가

        return answer;
    }
}
