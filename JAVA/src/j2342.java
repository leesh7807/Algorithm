import java.io.*;
import java.util.*;
class j2342 {
    static int INF = 10_0000_0000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp == 0) break;
            arr.add(temp);
        }
        int[][][] dp = new int[arr.size()][5][5];
        for(int i = 0; i < arr.size(); i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }
        int first = arr.get(0);
        dp[0][0][first] = 2;
        dp[0][first][0] = 2;
        for(int i = 1; i < arr.size(); i++) {
            int next = arr.get(i);
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(dp[i - 1][j][k] == INF || j == k) continue;
                    int left = 0;
                    int right = 0;
                    left = j == 0 ? 2 : (next == j ? 1 : (Math.abs(next - j) % 2 == 0 ? 4 : 3));
                    right = k == 0 ? 2 : (next == k ? 1 : (Math.abs(next - k) % 2 == 0 ? 4 : 3));
                    dp[i][next][k] = Math.min(dp[i - 1][j][k] + left, dp[i][next][k]);
                    dp[i][j][next] = Math.min(dp[i - 1][j][k] + right, dp[i][j][next]);
                }
            }
        }
        int ans = INF;
        for(int i = 0; i < 5; i++ ){
            for(int j = 0; j < 5; j++) {
                ans = Math.min(ans, dp[arr.size() - 1][i][j]);
            }
        }
        System.out.println(ans);
    }
}