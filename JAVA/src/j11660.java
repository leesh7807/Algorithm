import java.util.*;
import java.io.*;
public class j11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][N+1];
        for(int r=1; r<N+1; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<N+1; c++) {
                dp[r][c] = Integer.parseInt(st.nextToken()) + dp[r-1][c] + dp[r][c-1] - dp[r-1][c-1];
            }
        }
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            bw.write(Long.toString(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]) + "\n");
        }
        bw.close();
    }
}
