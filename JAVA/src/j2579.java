import java.io.*;
public class j2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n+1];
        for(int i=1; i<=n; i++) {
            int score = Integer.parseInt(br.readLine());
            stair[i] = score;
        }
        int[][] dp = new int[n+1][2];
        dp[1][0] = stair[1];
        dp[1][1] = stair[1];
        for(int i=2; i<=n; i++) {
            dp[i][0] = dp[i-1][1] + stair[i]; // 한칸. 이전에 두칸 걸어올라왔어야함.
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + stair[i]; // 두칸. 이전에 한칸vs두칸 

        }
        bw.write(Long.toString(Math.max(dp[n][0], dp[n][1])));
        bw.close();
    }
}