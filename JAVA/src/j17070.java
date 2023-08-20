import java.io.*;
import java.util.*;
public class j17070 {
    static int N;
    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(ans);
    }
    public static void dfs(int row, int col, int state) {
        if(row == N-1 && col == N-1) {
            ans++;
            return;
        }
        switch(state) {
            case 0 :
                // 가로
                if(col + 1 < N && arr[row][col+1] == 0) {
                    dfs(row, col+1, 0);
                }
                if(col + 1 < N && row + 1 < N && arr[row][col+1] == 0 && arr[row+1][col] == 0 && arr[row+1][col+1] == 0) {
                    dfs(row+1, col+1, 2);
                }
                break;
            case 1 :
                // 세로
                if(row + 1 < N && arr[row+1][col] == 0) {
                    dfs(row+1, col, 1);
                }
                if(col + 1 < N && row + 1 < N && arr[row][col+1] == 0 && arr[row+1][col] == 0 && arr[row+1][col+1] == 0) {
                    dfs(row+1, col+1, 2);
                }
                break;
            case 2 :
                // 대각선
                if(col + 1 < N && arr[row][col+1] == 0) {
                    dfs(row, col+1, 0);
                }
                if(row + 1 < N && arr[row+1][col] == 0) {
                    dfs(row+1, col, 1);
                }
                if(col + 1 < N && row + 1 < N && arr[row][col+1] == 0 && arr[row+1][col] == 0 && arr[row+1][col+1] == 0) {
                    dfs(row+1, col+1, 2);
                }
        }
    }
}
