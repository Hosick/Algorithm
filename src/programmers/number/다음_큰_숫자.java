package programmers.number;

class 다음_큰_숫자 {
    public int solution(int n) {
        int oneCount = getBinaryOneCount(n);
        while (oneCount != getBinaryOneCount(++n)) ;
        return n;
    }

    /* 2진수의 1개수 찾기 함수 */
    public int getBinaryOneCount(int n) {
        int count = 0;
        while (n >= 2) {
            if (n % 2 != 0)
                count++;
            n /= 2;
        }
        if (n == 1)
            count++;
        return count;
    }
}
