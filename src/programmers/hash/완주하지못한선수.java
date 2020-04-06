package programmers.hash;

import java.util.HashMap;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        /* <완주자, 인원>을 맵에 넣기 */
        for (String i : completion) {
            if (map.containsKey(i)) {   //  이미 있다면 인원++
                int cnt = map.get(i);
                map.remove(i);
                map.put(i, ++cnt);
            } else
                map.put(i, 1);          //  없다면 새로 put
        }

        /* 참가자를 맵에서 찾기 */
        for (String j : participant) {
            if (map.containsKey(j)) {   // 완주자 map에서 찾았을 때
                if (map.get(j) == 1)    //  동명이인이 없다면 remove
                    map.remove(j);
                else {                  //  동명이인이 있다면 인원--;
                    int cnt = map.get(j);
                    map.remove(j);
                    map.put(j, --cnt);
                }
            } else {    //  못찾았다면 return
                return j;
            }
        }
        return "";
    }
}