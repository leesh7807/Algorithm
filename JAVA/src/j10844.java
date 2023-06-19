import java.io.*;
public class j10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[10][101];
        for(int i=1; i<10; i++) {
            dp[i][1] = 1;
        }
        for(int j=2; j<101; j++) {
            for(int i=0; i<10; i++) {
                if(i==0) {
                    dp[i][j] = dp[1][j-1];
                }
                else if(i==9) {
                    dp[i][j] = dp[8][j-1];
                }
                else {
                    dp[i][j] = (dp[i-1][j-1]%1000000000 + dp[i+1][j-1]%1000000000)%1000000000;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<10; i++) {
            ans = (ans%1000000000 + dp[i][n]%1000000000)%1000000000;
        }
        bw.write(Long.toString(ans));
        bw.close();
    }
}
