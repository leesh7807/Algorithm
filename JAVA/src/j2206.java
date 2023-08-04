import java.io.*;
import java.util.*;
public class j2206 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        char[][] map = new char[N][M];
        for(int n=0; n<N; n++) {
            char[] line = br.readLine().toCharArray();
            for(int m=0; m<M; m++) {
                map[n][m] = line[m];
            }
        }
        LinkedList<Trio> queue = new LinkedList<>();
        int[][][] result = new int[N][M][2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                Arrays.fill(result[i][j], -1);
            }
        }
        queue.add(new Trio(0, 0, false));
        result[0][0][0] = 1;
        while(!queue.isEmpty()) {
            LinkedList<Trio> now = new LinkedList<>();
            while(!queue.isEmpty()) {
                now.add(queue.poll());
            }
            while(!now.isEmpty()) {
                Trio temp = now.poll();
                int row = temp.row;
                int col = temp.col;
                boolean isDestroy = temp.isDestroy;
                for(int d=0; d<4; d++) {
                    int newRow = row + dr[d];
                    int newCol = col + dc[d];
                    if(newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) continue;
                    // 벽부순적 있는 경우
                    if(isDestroy && map[newRow][newCol] == '0') {                        
                        if(result[newRow][newCol][1] == -1 ||
                        result[row][col][1] + 1 < result[newRow][newCol][1]) {
                            queue.add(new Trio(newRow, newCol , true));
                            result[newRow][newCol][1] = result[row][col][1] + 1;
                        }
                    }
                    // 부순적 x
                    else if(!isDestroy) {
                        // 벽없는 곳
                        if(map[newRow][newCol] == '0' && result[newRow][newCol][0] == -1) {
                            queue.add(new Trio(newRow, newCol, false));
                            result[newRow][newCol][0] = result[row][col][0] + 1;
                        }
                        // 벽 있는 곳
                        else {
                            if(result[newRow][newCol][1] == -1 ||
                            result[row][col][0] + 1 < result[newRow][newCol][1]) {
                                queue.add(new Trio(newRow, newCol, true));
                                result[newRow][newCol][1] = result[row][col][0] + 1;
                            }
                        }
                    }
                }
            }
        }
        int ans = Math.min(result[N-1][M-1][0], result[N-1][M-1][1]);
        if(ans == -1) {
            ans = result[N-1][M-1][0] == -1 ? result[N-1][M-1][1] : result[N-1][M-1][0];
        }
        System.out.println(ans);
    }
    static class Trio {
        int row, col;
        boolean isDestroy;
        public Trio(int row, int col, boolean isDestroy) {
            this.row = row;
            this.col = col;
            this.isDestroy = isDestroy;
        }
    }
}
