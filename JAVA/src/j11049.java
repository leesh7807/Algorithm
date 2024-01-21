import java.io.*;
import java.util.*;
public class j11049 {
    static int[][] mat;
    static int[][] cache;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        mat = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mat[i][0] = Integer.parseInt(st.nextToken());
            mat[i][1] = Integer.parseInt(st.nextToken());
        }
        cache = new int[N][N];
        for(int i = 0; i < N - 1; i++) {
            cache[i][i + 1] = mat[i][0] * mat[i][1] * mat[i + 1][1];
        }
        for(int interval = 2; interval < N; interval++) {
            for(int i = 0; i + interval < N; i++) {
                cache[i][i + interval] = Integer.MAX_VALUE;
                for(int j = 0; j < interval; j++) {
                    int candi = cache[i][i + j] + cache[i + j + 1][i + interval] + mat[i][0] * mat[i + j][1] * mat[i + interval][1];
                    cache[i][i + interval] = Math.min(candi ,cache[i][i + interval]);
                }
            }
        }
        System.out.println(cache[0][N - 1]);
    }
} 
