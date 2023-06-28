import java.io.*;
import java.util.*;
public class j11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=N; n++) {
            dp[n] = dp[n-1] + Integer.parseInt(st.nextToken());
        }
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken()); 
            bw.write(Long.toString(dp[j] - dp[i-1]) + '\n');
        }
        bw.close();
    }
}
