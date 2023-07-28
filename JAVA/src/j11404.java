import java.io.*;
import java.util.*;
public class j11404 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[from][to] = (arr[from][to] == 0) ? cost : Math.min(arr[from][to], cost);   
        }
        for(int mid=1; mid<N+1; mid++) {
            for(int from=1; from<N+1; from++) {
                for(int to=1; to<N+1; to++) {
                    if(arr[from][mid] == 0 || arr[mid][to] == 0 || from == to) continue;
                    int useMidDist = arr[from][mid] + arr[mid][to];
                    arr[from][to] = (arr[from][to] == 0) ? useMidDist : Math.min(arr[from][to], useMidDist);
                }
            }
        }
        for(int row=1; row<N+1; row++) {
            for(int col=1; col<N+1; col++) {
                bw.write(Long.toString(arr[row][col]) + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
