package programmers.string;

class JadenCase_문자열_만들기 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean isFirstFlag = true;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (c == ' ')
                isFirstFlag = true;
            else {
                if (isFirstFlag && ('a' <= c && c <= 'z'))
                    c -= 'a' - 'A';
                else if (!isFirstFlag && ('A' <= c && c <= 'Z'))
                    c += 'a' - 'A';
                isFirstFlag = false;
            }
            builder.append(c);
        }
        return builder.toString();
    }
}