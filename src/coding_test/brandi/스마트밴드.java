package coding_test.brandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class 스마트밴드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 220 - n;

        Map<Object, List<String>> values = br.lines()
                .collect(groupingBy(line -> {
                    if (Double.parseDouble((String) line) < max * 0.6) return 5;
                    else if (Double.parseDouble((String) line) < max * 0.68) return 4;
                    else if (Double.parseDouble((String) line) < max * 0.75) return 3;
                    else if (Double.parseDouble((String) line) < max * 0.80) return 2;
                    else if (Double.parseDouble((String) line) < max * 0.90) return 1;
                    else if (Double.parseDouble((String) line) <= max * 1) return 0;
                    else return 6;
                }));

        for (int i = 0; i < 6; ++i) {
            System.out.print(values.get(i).size() + " ");
        }
    }
}