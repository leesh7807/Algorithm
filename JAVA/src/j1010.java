import java.io.*;
import java.util.*;

public class j1010 {
    static int N;
    static int M;
    static int[][] cache = new int[31][31];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 0 < N <= M < 30
            bw.write(String.valueOf(Long.toString(comb(M, N)) + '\n'));
            bw.flush();
        }
        bw.close();
    }    
    public static int comb(int a, int b) {
        if(a == b) { 
            return 1;
        }
        else if(b == 1) {
            return a;
        }
        else if(cache[a][b] != 0) {
            return cache[a][b];
        }
        else return comb(a-1, b-1) + comb(a-1, b);
    }
}
