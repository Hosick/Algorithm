package programmers.greedy;

import java.util.Arrays;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] student = new int[n + 2]; //  for loop 수월함을 위해 1-n 앞뒤의 한개의 원소를 더 배치
        Arrays.fill(student, 1, n+1, 1);    //  1-n을 우선 1로채우고

        for (int i = 0; i < lost.length; ++i)   //  잃어버렸으면--
            --student[lost[i]];
        for (int i = 0; i < reserve.length; ++i)    //  여벌이있다면++
            ++student[reserve[i]];

        for(int i = 1; i <= n; ++i){
            if(student[i] == 0) //  체육복이 없을 때
            {
                if(student[i-1] == 2){  //  앞에서 빌리기
                    student[i-1]--;
                    student[i]++;
                    answer++;
                }
                else if(student[i+1] == 2){ //  뒤에서 빌리기
                    student[i+1]--;
                    student[i]++;
                    answer++;
                }
            }
            else                        //  체육복이 있을 때
                answer++;
        }
        return answer;
    }
}