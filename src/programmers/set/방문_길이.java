package programmers.set;

import java.util.HashSet;
import java.util.Set;

class 방문_길이 {
    public int solution(String dirs) {
        int x = 0;  //  현재 위치 x축
        int y = 0;  //  현재 위치 y축
        Set<String> set = new HashSet<>();  //  이동을 담을 Set

        /* 이동 시작 */
        for (int i = 0; i < dirs.length(); ++i) {
            char dir = dirs.charAt(i);

            // 판을 벗어나려는 명령은 무효
            if ((y == 5 && dir == 'U') || (y == -5 && dir == 'D') || (x == 5 && dir == 'R') || (x == -5 && dir == 'L'))
                continue;

            // 이동 명령과 현재 위치를 set 에 넣기
            set.add("".concat(String.valueOf(dir)).concat(String.valueOf(x)).concat(String.valueOf(y)));

            // 반대로 도착지 -> 출발지 또한 set 에 넣기
            if (dir == 'U') {
                set.add("D".concat(String.valueOf(x)).concat(String.valueOf(y + 1)));
                y++;
            } else if (dir == 'D') {
                set.add("U".concat(String.valueOf(x)).concat(String.valueOf(y - 1)));
                y--;
            } else if (dir == 'R') {
                set.add("L".concat(String.valueOf(x + 1)).concat(String.valueOf(y)));
                x++;
            } else if (dir == 'L') {
                set.add("R".concat(String.valueOf(x - 1)).concat(String.valueOf(y)));
                x--;
            }
        }

        return set.size() / 2;
    }
}