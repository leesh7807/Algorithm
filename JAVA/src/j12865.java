import java.io.*;
import java.util.*;

public class j12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        int[][] cache = new int[N+1][K+1];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<K+1; j++) {
                if(j < W[i]) {
                    cache[i][j] = cache[i-1][j];
                }
                else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j-W[i]] + V[i]);
                }
            }
        }
        bw.write(Long.toString(cache[N][K]));
        bw.close();
    }
}
