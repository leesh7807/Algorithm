import java.io.*;
import java.util.*;
public class j1113 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N, M, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) { 
                map[i][j] = s.charAt(j) - '0';
            }
        }
        for(int h = 1; h <= 9; h++) {
            boolean[][] isVisited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == h && !isVisited[i][j]) {
                        bfs(new int[] {i, j}, map, isVisited, h);
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static void bfs(int[] start, int[][] map, boolean[][] isVisited, int height) {
        LinkedList<int[]> queue = new LinkedList<>();
        ArrayList<int[]> candidate = new ArrayList<>();
        queue.add(start);
        candidate.add(start);
        isVisited[start[0]][start[1]] = true;
        int wallHeight = Integer.MAX_VALUE;
        boolean flood = false;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] == 0 || now[0] == N-1 || now[1] == 0 || now[1] == M-1) flood = true; // 테두리와 맞닿으면 물이 흘러넘친다.
            for(int d = 0; d < 4; d++) {
                int r2 = now[0] + dr[d];
                int c2 = now[1] + dc[d];
                if(r2 < 0 || r2 > N-1 || c2 < 0 || c2 > M-1 || isVisited[r2][c2]) continue;
                if(map[r2][c2] == height) {
                    isVisited[r2][c2] = true;
                    queue.add(new int[] {r2, c2});
                    candidate.add(new int[] {r2, c2});
                }
                else if(map[r2][c2] < height) {
                    flood = true;
                }
                else if(map[r2][c2] > height) {
                    wallHeight = Math.min(map[r2][c2], wallHeight);
                }
            }
        }
        if(!flood) {
            ans += candidate.size() * (wallHeight - height);
            for(int i = 0; i < candidate.size(); i++) {
                int[] now = candidate.get(i);
                map[now[0]][now[1]] = wallHeight;
                isVisited[now[0]][now[1]] = false;
            }
        }
    }
}
