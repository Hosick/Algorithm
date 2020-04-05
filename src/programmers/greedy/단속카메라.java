package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

class 단속카메라 {
    public static void main(String[] args) {
        int[][] arr = {{-20,15}, {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.print(solution(arr));
    }

    public static int solution(int[][] routes) {
        /* 출발점이 빠른 차량 순으로 정렬 */
        Comparator<int[]> cmp = (a, b) -> {
            return a[0] - b[0];
        };
        Arrays.sort(routes, cmp);

        /* */
        int answer = routes.length;
        boolean[] check = new boolean[answer];

        /*  */
        for (int i = 0; i < routes.length; ++i) {
            if (check[i]) continue;
            int meet = 0;
            for (int j = i + 1; j < routes.length; ++j) {
                if (routes[i][0] <= routes[j][0] && routes[j][0] <= routes[i][1]) {   //  차량 i와 j가 겹친다면 만난 j의 갯수만큼 --;
                    if (routes[i][0] <= routes[j][1] && routes[j][1] <= routes[i][1]) {   //  완전히 겹친다면 -1만 하고 break;
                        answer--;
                        meet = 0;
                        break;
                    }
                    meet++;
                    check[j] = true;
                }
            }
            answer -= meet;
        }
        return answer;
    }
}