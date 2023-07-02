import java.io.*;
import java.util.*;
public class j1389 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] table = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                table[i][j] = 1000; // Integer.MAX_VALUE 쓰니까 overflow로 음수 되버림. 다음에는 Integer 객체만들어서, null 비교를 쓰자.
            }
        }


        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            table[p1][p2] = 1;
            table[p2][p1] = 1;
        }
        for(int n=1; n<=N; n++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    table[i][j] = Math.min(table[i][j], table[i][n] + table[n][j]);
                }
            }
        }
        int sum = Integer.MAX_VALUE;
        int ans = -1;
        for(int n=1; n<=N; n++) {
            int tempSum = 0;
            for(int i=1; i<=N; i++) {
                if(i == n) continue;
                tempSum += table[n][i];
            }   
            if(tempSum < sum) {
                sum = tempSum;
                ans = n;
            }
        }
        System.out.println(ans);
    }
}
