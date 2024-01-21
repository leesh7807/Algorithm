import java.io.*;
import java.util.*;
public class j10942 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] seq = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] isPalin = new boolean[N + 1][N + 1];
        isPalin[1][1] = true;
        for(int i = 2; i <= N; i++) {
            isPalin[i][i] = true;
            if(seq[i - 1] == seq[i]) {
                isPalin[i - 1][i] = true;
            }
        }
        for(int interval = 2; interval < N; interval++) {
            for(int i = 1; i + interval <= N; i++) {
                if(seq[i] == seq[i + interval] && isPalin[i + 1][i + interval - 1]) {
                    isPalin[i][i + interval] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if(isPalin[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]) {
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }
        System.out.println(sb.toString());
    }
}
