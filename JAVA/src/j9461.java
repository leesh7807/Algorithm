import java.io.*;
public class j9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long[] dp = new Long[101];
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        dp[4] = 2L;
        dp[5] = 2L;
        for(int i=6; i<=100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(Long.toString(dp[N]) + '\n');
        }
        bw.close();
    }
}
