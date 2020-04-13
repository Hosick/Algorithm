package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";

        /* int 배열 numbers를 String으로 변환하여 String배열 arr에 넣기 */
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; ++i)
            arr[i] = Integer.toString(numbers[i]);

        /* 두 수를 붙여봤을 때 앞쪽이었을 때 크다면 return -1 */
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        /* 큰 수부터 answer에 붙히기 */
        for (String i : arr)
            answer += String.valueOf(i);    //  answer += i 보다 성능이 좋음
        if (answer.charAt(0) == '0')        //  만약 가장 앞자리가 0인 수라면 "0"만 return
            return "0";

        return answer;
    }
}
