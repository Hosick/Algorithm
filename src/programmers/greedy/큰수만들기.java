/**
처음에는 문자를 하나 씩 지워나가는 방법으로 했지만 시간복잡도가 O(n^2)이기 때문에 시간초과가 발생한다
answer에 문자를 하나 씩 넣는 방식으로 풀어야한다.
**/

package programmers.greedy;

class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int start = 0;  //  최대값을 찾을 부분의 시작 index
        int end = k;    //  최대값을 찾을 부분의 마지막 index
        while (k > 0) {
            int max = start;    //  최대값을 우선 start로 초기화 후
            for (int i = start + 1; i <= end; ++i) {    //  end까지 탐색하며 최대값의 index를 찾는다
                max = (number.charAt(i) > number.charAt(max)) ? i : max;
            }

            answer.append(number.charAt(max));  //  최대값을 answer에 삽입 하고
            if (answer.length() == number.length() - k) //  만약 k를 모두 날렸다면 return
                return answer.toString();
            k -= max - start;   //  최대값의 index - start 만큼을 날린다.
            start = max + 1;    //  시작점은 max index의 다음부터
            end = start + k;    //  end는 시작점 + 더 날려야 할 index
        }
        if (start < number.length()) {              //  남은 문자열들을 추가로 삽입
            answer.append(number.substring(start));
        }

        return answer.toString();   //  return
    }
}