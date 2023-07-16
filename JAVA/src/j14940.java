import java.io.*;
import java.util.*;
public class j14940 {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        LinkedList<Pair> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int v = Integer.parseInt(st.nextToken());
                if(v==2) {
                    q.add(new Pair(i, j));
                    isVisited[i][j] = true;
                }
                if(v==0) {
                    isVisited[i][j] = true;
                }
                arr[i][j] = v;
            }
        }
        int dis = 1;
        while(!q.isEmpty()) {
            LinkedList<Pair> move = new LinkedList<>();
            while(!q.isEmpty()) {
                move.add(q.poll());
            }
            while(!move.isEmpty()) {
                Pair now = move.poll();
                for(int d=0; d<4; d++) {
                    int r2 = now.r + dy[d];
                    int c2 = now.c + dx[d];
                    if(r2>=0 && r2<n && c2>=0 && c2<m && !isVisited[r2][c2]) {
                        q.add(new Pair(r2, c2));
                        isVisited[r2][c2] = true;
                        result[r2][c2] = dis;
                    }
                }
            }
            dis++;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!isVisited[i][j]) {
                    result[i][j] = -1;
                }
                bw.write(Long.toString(result[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
