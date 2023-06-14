import java.util.*;
import java.io.*;
public class j1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] tri = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0) {
                    tri[i][j] += tri[i-1][j];
                }
                else if(j == i) {
                    tri[i][j] += tri[i-1][j-1];
                }
                else {
                    tri[i][j] += Math.max(tri[i-1][j-1], tri[i-1][j]);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, tri[n-1][i]);
        }
        bw.write(Long.toString(ans));
        bw.close();
    }
}
