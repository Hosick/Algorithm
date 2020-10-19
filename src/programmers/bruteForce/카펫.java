package programmers.bruteForce;

class 카펫 {
    public int[] solution(int brown, int yellow) {
        for (int w = 3; w < 2500; ++w) {
            for (int h = 3; (w * h) <= (brown + yellow); ++h) {
                if (yellow == (w - 2) * (h - 2) && brown == (w + h) * 2 - 4) {
                    return new int[]{h, w};
                }
            }
        }
        return new int[]{};
    }
}
