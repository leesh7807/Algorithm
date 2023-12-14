import java.io.*;
public class j1562_bitmask {
    static int N;
    static final int MOD =  1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[][][] dp = new long[N + 1][10][(1 << 10)];
        for(int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }
        for(int n = 2; n <= N; n++) {
            for(int i = 0; i < 10; i++) {
                for(int path = 0; path < 1 << 10; path++) {
                    if(i == 0) {
                        dp[n][i][path | (1 << i)] += dp[n - 1][i + 1][path] % MOD;
                    }
                    else if(i == 9) {
                        dp[n][i][path | (1 << i)] += dp[n - 1][i - 1][path] % MOD;
                    }
                    else {
                        dp[n][i][path | (1 << i)] += (dp[n - 1][i + 1][path] + dp[n - 1][i - 1][path]) % MOD;
                    }
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i][(1 << 10) - 1]) % MOD;
        }
        System.out.println(ans);
    }
}
