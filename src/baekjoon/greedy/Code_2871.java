package baekjoon.greedy;

import java.util.*;

public class Code_2871 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();        //  단어의 길이 입력
        String word = input.next();     //  단어 입력
        int[] alphabet = new int[26];   //  알파벳 배열
        Map<Character, Stack<Integer>> map = new HashMap<>();   //  <알파벳, 스택<idx>> 맵 선언
        boolean[] vis = new boolean[n]; //
        input.close();

        for (int i = 0; i < 26; ++i)
            map.put((char) ('a' + i), new Stack<>());

        for (int i = 0; i < n; ++i) {
            char temp = word.charAt(i);
            alphabet[temp - 'a']++;
            map.get(temp).push(i);
            vis[i] = false;
        }

        int now = 0;
        int it = n;
        String my = "";
        String your = "";
        while (now < n) {
            --it;
            while (vis[it] || alphabet[word.charAt(it) - 'a'] <= 0)
                --it;

            your += word.charAt(it);
            alphabet[word.charAt(it) - 'a']--;
            map.get(word.charAt(it)).pop();
            vis[it] = true;
            now++;

            char cur = 0;
            for (int i = 0; i < 26; ++i) {
                if (alphabet[i] > 0) {
                    cur = (char) ('a' + i);
                    alphabet[i]--;
                    now++;
                    break;
                }
            }
            my += cur;
            int pos = map.get(cur).peek();
            map.get(cur).pop();
            vis[pos] = true;
        }

        for (int i = 0; i < n / 2; ++i) {
            if (my.charAt(i) < your.charAt(i)) {
                System.out.println("DA");
                break;
            }
            if (i == n / 2 - i)
                System.out.println("NE");
        }

        System.out.println(my);
    }
}
