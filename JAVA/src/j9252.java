import java.io.*;
public class j9252 {
    static StringBuilder sb = new StringBuilder();
    static char[] s1;
    static char[] s2;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        dp = new int[s1.length + 1][s2.length + 1];
        for(int i = 1; i <= s1.length; i++) {
            for(int j = 1; j <= s2.length; j++) {
                if(s1[i - 1] == s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                if(dp[i - 1][j] > dp[i][j])
                    dp[i][j] = dp[i - 1][j];
                if(dp[i][j - 1] > dp[i][j])
                    dp[i][j] = dp[i][j - 1];
            }
        }
        int r = s1.length;
        int c = s2.length;
        while(r > 0 && c > 0) {
            if(dp[r - 1][c] == dp[r][c]) {
                r--;
            }
            else if(dp[r][c - 1] == dp[r][c]) {
                c--;
            }
            else {
                sb.append(s1[r - 1]);
                r--;
                c--;
            }
        }
        System.out.println(dp[s1.length][s2.length]);
        System.out.println(sb.reverse().toString());
    }
}
