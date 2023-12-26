import java.io.*;
import java.util.*;
public class j1799 {
    static int N;
    static int oddMax = 0;
    static int evenMax = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0, 0, board);
        search(1, 0, board);
        System.out.println(evenMax + oddMax);
    }
    static int[][] dir = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public static void search(int s, int cnt, int[][] board) throws Exception{
        for(int sum = s; sum <= 2 * (N - 1); sum += 2) {
            for(int i = 0; i < N; i++) {
                int j = sum - i;
                if(j < 0 || j >= N) continue;
                if(board[i][j] > 0) {
                    for(int d = 0; d < 4; d++) {
                        int r = i;
                        int c = j;
                        while(r >= 0 && r < N && c >= 0 && c < N) {
                            board[r][c]--;
                            r += dir[d][0];
                            c += dir[d][1];
                        }
                    }
                    if(sum % 2 == 0) evenMax = Math.max(evenMax, cnt + 1);
                    else oddMax = Math.max(oddMax, cnt + 1);
                    search(s + 2, cnt + 1, board);
                    for(int d = 0; d < 4; d++) {
                        int r = i;
                        int c = j;
                        while(r >= 0 && r < N && c >= 0 && c < N) {
                            board[r][c]++;
                            r += dir[d][0];
                            c += dir[d][1];
                        }
                    }
                }
            }
        }
    }
}
