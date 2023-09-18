import java.io.*;
public class j1229 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sixNum = new int[1000];
        sixNum[1] = 1;
        sixNum[2] = 6;
        for(int i=3; i<1000; i++) {
            sixNum[i] = i + (i-1) * 3 + sixNum[i-1];
        } 
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<1000; i++) {
            if(sixNum[i] > n) break;
            else dp[sixNum[i]] = 1;
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<1000; j++) {
                if(i + sixNum[j] > n) break;
                dp[i+sixNum[j]] = Math.min(dp[i+sixNum[j]], dp[i] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
