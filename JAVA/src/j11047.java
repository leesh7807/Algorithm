import java.util.*;
import java.io.*;
public class j11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        int sum = K;
        int ans = 0;
        while(sum != 0) {
            ans++;
            int start = 0;
            int end = N-1;
            while(start < end) {
                int mid = (int)Math.ceil((start + end) / 2.);
                if(arr[mid] <= sum) {
                    start = mid;
                }
                else {
                    end = mid - 1;
                }
            }
            sum -= arr[end];
        }
        System.out.println(ans);
    }
}
