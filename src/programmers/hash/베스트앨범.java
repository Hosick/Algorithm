package programmers.hash;

import java.util.*;

class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        /* 해시맵에 장르별 총 플레이 수 넣기*/
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; ++i) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        /* value(플레이 수) 기준으로 장르를 내림차순 정렬 */
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        /* ArrayList에 장르별 1-2개씩 넣기 */
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            int idx1 = -1;
            int idx2 = -1;
            int value1 = 0;
            int value2 = 0;
            for (int j = 0; j < genres.length; ++j) {
                if (genres[j].equals(list.get(i).getKey())) {
                    if (plays[j] > value2) {
                        if (plays[j] > value1) {
                            idx2 = idx1;
                            value2 = value1;
                            idx1 = j;
                            value1 = plays[j];
                            continue;
                        }
                        idx2 = j;
                        value2 = plays[j];
                    }
                }
            }
            if (idx1 > -1)
                al.add(idx1);
            if (idx2 > -1)
                al.add(idx2);
        }

        /* int배열 answer로 옮기고 return */
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); ++i)
            answer[i] = al.get(i);
        return answer;
    }
}