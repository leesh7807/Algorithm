import java.io.*;
import java.util.*;
public class j9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[2][N];
            for(int row=0; row<2; row++) {
                st = new StringTokenizer(br.readLine());
                for(int n=0; n<N; n++) {
                    arr[row][n] = Integer.parseInt(st.nextToken());                    
                }
            }
            int[][] dp = new int[2][N+2];
            for(int i=2; i<N+2; i++) {
                dp[0][i] = arr[0][i-2] + Math.max(dp[1][i-2], dp[1][i-1]);
                dp[1][i] = arr[1][i-2] + Math.max(dp[0][i-2], dp[0][i-1]);
            }
            bw.write(Long.toString(Math.max(dp[0][N+1], dp[1][N+1])) + "\n");
        }
        bw.close();
    }
}
