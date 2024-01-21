import java.io.*;
import java.util.*;
public class j12100 {
    static int N;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(arr, 0);
        System.out.println(ans);
    }
    static void solve(int[][] arr, int depth) {
        if(depth == 5) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    ans = Math.max(arr[i][j], ans);
                }
            }
            return;
        }
        solve(up(arr), depth + 1);
        arr = rotate(arr);
        solve(up(arr), depth + 1);
        arr = rotate(arr);
        solve(up(arr), depth + 1);
        arr = rotate(arr);
        solve(up(arr), depth + 1);
    }
    static int[][] up(int[][] arr) {
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        for(int j = 0; j < N; j++) {
            int prev = temp[0][j];
            int pos = 0;
            for(int i = 1; i < N; i++) {
                if(temp[i][j] == 0) {
                    continue;
                }
                if(temp[i][j] == prev) {
                    temp[pos][j] = prev * 2;
                    temp[i][j] = 0;
                    prev = 0;
                    pos++;
                }
                else if(temp[i][j] > 0) {
                    if(prev > 0) {
                        pos++;
                    }
                    temp[pos][j] = temp[i][j];
                    if(pos != i) {
                        temp[i][j] = 0;
                    }
                    prev = temp[pos][j];
                }
            }
        }
        return temp;
    }
    static int[][] rotate(int[][] arr) {
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                temp[i][j] = arr[j][N - 1 - i];
            }
        }
        return temp;
    }
}
