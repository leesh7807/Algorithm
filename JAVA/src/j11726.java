import java.io.*;
public class j11726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<1001; i++) {
            dp[i] = (dp[i-1]%10007 + dp[i-2]%10007) % 10007;
        }
        int n = Integer.parseInt(br.readLine());
        bw.write(Long.toString(dp[n]));
        bw.close();
    }
}
