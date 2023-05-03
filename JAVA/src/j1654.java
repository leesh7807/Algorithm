import java.io.*;
import java.util.*;

// 2초, 128MB
// 결국 nlogn으로 탐색해야.

public class j1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 보유 수 1~10000
        int N = Integer.parseInt(st.nextToken()); // 필요한 수 1~1000000
        int[] Lan = new int[K]; // 보유 랜선 K개 길이
        long end = 0;
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            Lan[i] = Integer.parseInt(st.nextToken()); // 인트 범위 자연수
            end = Math.max(end, Lan[i]);
        }
        long start = 1; // 0으로 하면 mid가 0이 될 수 있음. / by zero error 유발.
        while(start <= end) {
            long mid = (start + end) / 2;
            if(N <= cutting(Lan, mid)) {
                start = mid + 1;
            }
            else if(N > cutting(Lan, mid)) {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(start - 1));
        bw.close();
    }
    public static int cutting(int[] arr, long len) {
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            cnt += arr[i]/len;
        }
        return cnt;
    }
}
