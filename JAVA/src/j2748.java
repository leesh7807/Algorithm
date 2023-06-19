import java.io.*;
public class j2748 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Long[] dp = new Long[91];
        dp[0] = 0L;
        dp[1] = 1L;
        for(int i=2; i<91; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        bw.write(Long.toString(dp[n]));
        bw.close();
    }
}
