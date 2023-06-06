import java.util.*;
import java.io.*;
public class j1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][3];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); 
            int g = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            arr[i][0] = Math.min(arr[i-1][1]+r, arr[i-1][2]+r); // 빨강 색칠할 때 이전에 초록 또는 파랑 사용한 케이스
            arr[i][1] = Math.min(arr[i-1][0]+g, arr[i-1][2]+g); // 초록
            arr[i][2] = Math.min(arr[i-1][0]+b, arr[i-1][1]+b); // 파랑
        }
        int ans = Math.min(arr[N][0], arr[N][1]);
        ans = Math.min(ans, arr[N][2]);
        bw.write(Long.toString(ans));
        bw.close();
    }
}
