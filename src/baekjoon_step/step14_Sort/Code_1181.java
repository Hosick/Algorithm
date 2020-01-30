package baekjoon_step.step14_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Code_1181 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        String[] words = new String[n];
        for (int i = 0; i < n; ++i)
            words[i] = input.next();

        /*String 배열 정렬*/
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) //  길이가 같다면
                    for (int i = 0; i < o1.length(); ++i) { //  앞 글자부터 사전순으로 비교
                        if (o1.charAt(i) == o2.charAt(i))
                            continue;
                        else {
                            return Integer.compare(o1.charAt(i), o2.charAt(i));
                        }
                    }
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (int i = 0; i < n; ++i) {
            if (i > 0 && words[i - 1].equals(words[i])) continue;   //  중복 제거
            System.out.println(words[i]);
        }
    }
}
