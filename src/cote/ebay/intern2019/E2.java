package cote.ebay.intern2019;

class E2 {
    public boolean solution(String s, String t) {
        int gcd = getGCD(s.length(), t.length());

        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) != t.charAt(i % gcd)) return false;
        for (int i = 0; i < t.length(); ++i)
            if (t.charAt(i) != s.charAt(i % gcd)) return false;
        return true;
    }

    public int getGCD(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}