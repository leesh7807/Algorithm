import java.io.*;
import java.util.*;

public class j14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1~15
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());// 1~5 t
            P[i] = Integer.parseInt(st.nextToken()); // 1~1000 p  
        }
        // n일에서 t일 일하면 n+t일에 돈을 받는다. n+t일에서 최대 수익 = (내가 n일까지 벌 수 있는 최대 돈 + n일에서 t일 일한돈) vs n일 째 일 안했을 때 돈.
        int[][] table = new int[N+2][N+2];
        for(int i=1; i<N+2; i++) {
            for(int j=1; j<N+2; j++) {
                if(j < i + T[i]) {
                    table[i][j] = table[i-1][j];
                }
                else {
                    table[i][j] = Math.max(table[i-1][j], table[i-1][i] + P[i]);
                }
            }
        }
        bw.write(Long.toString(table[N+1][N+1]));
        bw.close();
    }   
}