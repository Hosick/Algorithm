package baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Code_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i){
            int result = Arrays.stream(br.readLine().split(","))
                                .mapToInt(Integer::parseInt)
                                .sum();
            System.out.println(result);
        }
    }
}
