package programmers.hash;

import java.util.Arrays;

public class 전화번호부목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (a, b) -> Integer.compare(a.length(), b.length())); //  문자열의 길이 순으로 정렬

        for (int i = 0; i < phone_book.length; ++i) {
            for (int j = i + 1; j < phone_book.length; ++j) {   //  자신보다 긴 문자열만 검사
                if (phone_book[j].startsWith(phone_book[i]))    //  stratsWith로 접두사 검사
                    return false;
            }
        }
        return true;
    }
}