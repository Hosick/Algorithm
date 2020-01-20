package baekjoon_step.step7_Function;

public class Code_15596 {
    long sum(int[] a) {
        long ans = 0;
        for (int i = 0; i < a.length; ++i)
            ans += a[i];
        return ans;
    }
}
