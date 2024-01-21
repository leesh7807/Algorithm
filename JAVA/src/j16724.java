import java.io.*;
import java.util.*;
public class j16724 {
    static int N, M;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] isVisited;
    static boolean[][] hasSafe;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        hasSafe = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(line[j] == 'D') {
                    map[i][j] = 0;
                }
                else if(line[j] == 'U') {
                    map[i][j] = 1;
                }
                else if(line[j] == 'R') {
                    map[i][j] = 2;
                }
                else if(line[j] == 'L') {
                    map[i][j] = 3;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!isVisited[i][j]) {
                    if(bfs(i, j)) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static boolean bfs (int r, int c) {
        LinkedList<Pair> q = new LinkedList<>();
        LinkedList<Pair> visited = new LinkedList<>();
        q.add(new Pair(r, c));
        visited.add(new Pair(r, c));
        while(!q.isEmpty()) {
            Pair now = q.poll();
            isVisited[now.r][now.c] = true;
            int d = map[now.r][now.c];
            Pair next = new Pair(now.r + dr[d], now.c + dc[d]);
            // 이미 안전지대 있는 곳이면
            if(hasSafe[next.r][next.c]) {
                while(!visited.isEmpty()) {
                    Pair temp = visited.poll();
                    hasSafe[temp.r][temp.c] = true;
                }
                return false;
            }
            if(!isVisited[next.r][next.c]) {
                q.add(next);
                visited.add(next);
            }
            else {
                while(!visited.isEmpty()) {
                    Pair temp = visited.poll();
                    hasSafe[temp.r][temp.c] = true;
                }
            }
        }
        return true;
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
