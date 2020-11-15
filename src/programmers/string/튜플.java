package programmers.string;

import java.util.*;

class 튜플 {
    public int[] solution(String s) {
        s = s.replace('{', ' ').replace('}', ' ');
        String[] tuple = s.split(",");
        Map<Integer, Integer> map = new HashMap<>();
        for (String t : tuple) {
            int key = Integer.parseInt(t.trim());
            if (!map.containsKey(key))
                map.put(key, 1);
            else
                map.put(key, map.remove(key) + 1);
        }

        int[] answer = new int[map.size()];
        int find = answer.length;
        for (int i = 0; i < answer.length; ++i) {
            for (int j : map.keySet()) {
                if (map.get(j) == find) {
                    answer[i] = j;
                    map.remove(j);
                    find--;
                    break;
                }
            }
        }

        return answer;
    }
}