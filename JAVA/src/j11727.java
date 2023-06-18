import java.io.*;
public class j11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 1 + 2;
        for(int i=3; i<n+1; i++) {
            dp[i] = (dp[i-1]%10007 + (dp[i-2] * 2)%10007)%10007;
        }
        System.out.print(dp[n]);
    }
}
