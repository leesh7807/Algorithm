import java.io.*;
import java.util.*;
public class j2638 {
    static int N, M;
    static int[][] arr;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while(isCheese()) {
            LinkedList<Pair> queue = new LinkedList<>();
            boolean[][] isAir = new boolean[N][M];
            queue.add(new Pair(0, 0));
            isAir[0][0] = true;
            // 치즈 외부 공간 탐색
            while(!queue.isEmpty()) {
                Pair coord = queue.poll();
                int r = coord.r;
                int c = coord.c;
                for(int d=0; d<4; d++) {
                    int r2 = r + dr[d];
                    int c2 = c + dc[d];
                    if(r2 < 0 || r2 >= N || c2 < 0 || c2 >= M || isAir[r2][c2] || arr[r2][c2] == 1) continue;
                    queue.add(new Pair(r2, c2));
                    isAir[r2][c2] = true;
                }
            }
            // 녹는 치즈
            for(int r=0; r<N; r++) {
                for(int c=0; c<M; c++) {
                    if(arr[r][c] == 1) {
                        int cnt = 0;
                        for(int d=0; d<4; d++) {
                            int r2 = r + dr[d];
                            int c2 = c + dc[d];
                            if(r2 < 0 || r2 >= N || c2 < 0 || c2 >= M) continue;
                            if(isAir[r2][c2]) cnt++;
                        }
                        if(cnt >= 2) arr[r][c] = 0;
                    }   
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
    static boolean isCheese() {
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                if(arr[n][m] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
