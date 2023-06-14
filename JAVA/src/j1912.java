import java.util.*;
import java.io.*;
public class j1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine());
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            if(dp[i-1] > 0 && dp[i] + dp[i-1] > 0) {
                dp[i] += dp[i-1];
            }
            ans = Math.max(ans, dp[i]);
        }
        ans = Math.max(ans, dp[0]);
        bw.write(Long.toString(ans));
        bw.close();
    }
}