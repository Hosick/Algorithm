package baekjoon_step.step14_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            num.add(Integer.parseInt(br.readLine()));

        Collections.sort(num);

        for (int i = 0; i < n; ++i)
            System.out.println(num.get(i));

        br.close();
    }
}
