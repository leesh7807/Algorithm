import java.io.*;
import java.util.*;
public class j17404 {
    static int INF = 1000 * 1000 + 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] color = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }
        int ans = INF; 
        for(int c = 0; c < 3; c++) {
            int[][] dp = new int[N][3];
            dp[0][0] = INF;   
            dp[0][1] = INF;
            dp[0][2] = INF;   
            dp[0][c] = color[0][c];
            for(int i = 1; i < N; i++) {
                dp[i][0] = color[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = color[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = color[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            ans = Math.min(ans, Math.min(dp[N - 1][(c + 1) % 3], dp[N - 1][(c + 2) % 3]));
        }
        System.out.println(ans);
    }
}
