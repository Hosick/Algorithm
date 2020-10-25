package programmers.number;

class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        long GCD = getGCD(Math.max(w, h), Math.min(w, h));

        return (long)w * (long)h - (w + h - GCD);
    }

    /* 유클리드 호제법을 이용해 최대공약수 구하는 함수 */
    public long getGCD(int x, int y) {
        while (x % y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return y;
    }
}
