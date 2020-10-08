package programmers.collection_season_1;

public class 삼각_달팽이 {
    public int[] solution(int n) {
        int triangularNumber = getTriangularNumber(n);  //  삼각수 변수
        int[] answer = new int[triangularNumber];   //  삼각수 배열

        int nowIdx = 0; //  현재 배열 인덱스
        int nowNum = 1; //  현재 삽입할 값
        int nowFloor = 1;//  현재 층

        /* 0 단계 */
        for (int i = 0; i < n - 1; ++i) {
            answer[nowIdx] = nowNum++;
            nowIdx += nowFloor++;
        }

        /* 1 ~ (n - 1) 단계 */
        int step = 1;   //  현재 단계
        while (step < n) {
            for (int i = 0; i < (n - step); ++i) {
                answer[nowIdx] = nowNum++;
                if (step % 3 == 1)
                    nowIdx++;
                else if (step % 3 == 2)
                    nowIdx -= nowFloor--;
                else
                    nowIdx += nowFloor++;
            }
            step++;
        }

        //마지막 인덱스 값 찍기
        answer[nowIdx] = nowNum;

        return answer;
    }

    /* 삼각수 구하기 함수 */
    public int getTriangularNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; ++i)
            result += i;
        return result;
    }
}