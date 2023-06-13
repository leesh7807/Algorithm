import java.io.*;
public class j2775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];
        for(int i=1; i<15; i++) {
            dp[0][i] = i;
        }
        for(int i=1; i<15; i++) {
            for(int j=1; j<15; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        for(int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(Long.toString(dp[k][n]) + '\n');
        }
        bw.close();
    }
}
