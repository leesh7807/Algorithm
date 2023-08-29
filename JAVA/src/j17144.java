import java.io.*;
import java.util.*;
public class j17144 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];
        LinkedList<Trio> q = new LinkedList<>();
        int down = -1;
        for(int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++) {
                int val = Integer.parseInt(st.nextToken());
                if(val > 0) q.add(new Trio(r, c, val));
                if(val == -1) down = r;
                arr[r][c] = val;
            }
        }
        int up = down - 1;
        while(T-- > 0) {
            LinkedList<Trio> now = new LinkedList<>();
            while(!q.isEmpty()) {
                now.add(q.poll());
            }
            while(!now.isEmpty()) {
                Trio coord = now.poll();
                int r = coord.r;
                int c = coord.c;
                int w = coord.w;
                for(int d=0; d<4; d++) {
                    int r2 = r + dr[d];
                    int c2 = c + dc[d];
                    if(r2 < 0 || r2 >= R || c2 < 0 || c2 >= C || arr[r2][c2] == -1) continue;
                    arr[r][c] -= w/5;
                    arr[r2][c2] += w/5;
                }
            }
            for(int r=up-1; r>0; r--) {
                arr[r][0] = arr[r-1][0];
            }
            for(int r=down+1; r<R-1; r++) {
                arr[r][0] = arr[r+1][0];
            }
            for(int c=0; c<C-1; c++) {
                arr[0][c] = arr[0][c+1];
                arr[R-1][c] = arr[R-1][c+1];
            }
            for(int r=0; r<up; r++) {
                arr[r][C-1] = arr[r+1][C-1];
            }
            for(int r=R-1; r>down; r--) {
                arr[r][C-1] = arr[r-1][C-1];
            }
            for(int c=C-1; c>1; c--) {
                arr[up][c] = arr[up][c-1];
                arr[down][c] = arr[down][c-1];
            }
            arr[up][1] = 0;
            arr[down][1] = 0;
            for(int r=0; r<R; r++) {
                for(int c=0; c<C; c++) {
                    if(arr[r][c] > 0) q.add(new Trio(r, c, arr[r][c]));
                }
            }
        }
        int ans = 0;
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(arr[r][c] > 0) ans += arr[r][c];
            }
        }
        System.out.println(ans);
    }
    static class Trio {
        int r, c, w;
        public Trio(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
}