import java.io.*;
import java.util.*;
public class j16946 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = temp[j] - '0';
            }
        }
        HashMap<Integer, Integer> local = new HashMap<>();
        boolean[][] isVisited = new boolean[N][M];
        int localIdx = 101;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    int cnt = 0;
                    LinkedList<Coord> q = new LinkedList<>();
                    isVisited[i][j] = true;
                    q.add(new Coord(i, j));
                    while(!q.isEmpty()) {
                        Coord now = q.poll();
                        cnt++;
                        map[now.r][now.c] = localIdx;
                        for(int d = 0; d < 4; d++) {
                            int r2 = now.r + dr[d];
                            int c2 = now.c + dc[d];
                            if(r2 < 0 || r2 >= N || c2 < 0 || c2 >= M || isVisited[r2][c2] || map[r2][c2] > 0) continue;
                            isVisited[r2][c2] = true;
                            q.add(new Coord(r2, c2));
                        }
                    }
                    local.put(localIdx, cnt);
                    localIdx++;
                }
            }
        }
        int[][] ans = new int[N][M];
        for(int i = 0; i < N; i++) { 
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    HashSet<Integer> touchedLocal = new HashSet<>(4);
                    for(int d = 0; d < 4; d++) {
                        int r2 = i + dr[d];
                        int c2 = j + dc[d];
                        if(r2 < 0 || r2 >= N || c2 < 0 || c2 >= M || map[r2][c2] < 100) continue;
                        touchedLocal.add(map[r2][c2]);
                    }
                    for(int key : touchedLocal) {
                        ans[i][j] += local.get(key);
                    }
                    ans[i][j] = (ans[i][j] + 1) % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(Long.toString(ans[i][j]));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static class Coord {
        int r, c;
        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
