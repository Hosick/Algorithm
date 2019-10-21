package baekjoon_step.step3_For;

import java.io.*;

public class Code_15552 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        String line;
        int a, b;

        for (int i = 0; i < n; ++i) {
            line = bufferedReader.readLine();
            String[] num = line.split(" ");
            a = Integer.parseInt(num[0]);
            b = Integer.parseInt(num[1]);
            bufferedWriter.write(String.valueOf(a+b)+"\n");
        }
        bufferedWriter.flush();
    }
}