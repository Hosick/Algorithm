package programmers.string;

class 최댓값과_최솟값 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] sArr = s.split(" ");
        for (String i : sArr) {
            int n = Integer.parseInt(i);
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        builder.append(min+" "+max);

        return builder.toString();
    }
}