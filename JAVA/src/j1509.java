import java.io.*;
public class j1509 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        isPalin[0][0] = true;
        for(int i = 1; i < s.length(); i++) {
            isPalin[i][i] = true;
            if(s.charAt(i) == s.charAt(i - 1)) {
                isPalin[i-1][i] = true;
            }
        }
        for(int length = 2; length < s.length(); length++) {
            for(int i = 0; i < s.length() - length; i++) {
                if(s.charAt(i) == s.charAt(i + length) && isPalin[i+1][i + length - 1]) {
                    isPalin[i][i + length] = true;
                }
            }
        }
        int[] dp = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i] = 2501;
        }
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            for(int j = i; j >= 0; j--) {
                if(isPalin[j][i]) {
                    if(j - 1 < 0) dp[i] = 1;
                    else dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[s.length() - 1]);
    }
}
