import java.io.*;
public class j2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] juice = new int[n+1];
        for(int i=1; i<=n; i++) {
            juice[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][2];
        dp[1][0] = juice[1];
        dp[1][1] = juice[1];
        for(int i=2; i<=n; i++) {
            dp[i][0] = dp[i-1][1] + juice[i]; // 연속으로 마시는 경우
            int temp = 0;
            for(int j=i-2; j>0; j--) {
                temp = Math.max(temp, Math.max(dp[j][0], dp[j][1])); // 여러 칸 건너뛰는 경우를 고려해야함. 100 10 10 100 100
            }
            dp[i][1] = temp + juice[i]; // 건너뛰고 마시는 경우
        }
        int ans = Math.max(dp[n][0], Math.max(dp[n][1], Math.max(dp[n-1][0], dp[n-1][1])));
        bw.write(Long.toString(ans));
        bw.close();
    }
}
/*
 * 0 6 16 23 28 33 32 
 * 0 6 10 19 25 31 29
 *   6 10 13  9  8  1
 */