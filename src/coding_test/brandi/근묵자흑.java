package coding_test.brandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근묵자흑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //  배열의 길이
        int k = Integer.parseInt(st.nextToken());   //  한 번에 골라야 하는 길이
        int arr[] = new int[n];                     //  배열 선언
        int minIdx = 0;                             //  최소값(1)의 인덱스
        int count = 0;                              //  총 실행한 횟수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) minIdx = i;
        }

        int left = minIdx;
        int right = n - (minIdx + 1);
        int div = left % (k - 1) + right % (k - 1);
        count += left / (k - 1);
        count += right / (k - 1);
        if (div <= (k - 1) && div > 0)
            count++;
        else if (div >= (k - 1))
            count += 2;

        System.out.println(count);
    }
}