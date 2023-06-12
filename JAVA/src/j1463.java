import java.io.*;
public class j1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<1000001; i++) {
            int next = dp[i-1] + 1;
            if(i%2 == 0) {
                next = Math.min(next, dp[i/2] + 1);
            }
            if(i%3 == 0) {
                next = Math.min(next, dp[i/3] + 1);
            }
            dp[i] = next;
        }
        bw.write(Long.toString(dp[x]));
        bw.close();
    }
}
