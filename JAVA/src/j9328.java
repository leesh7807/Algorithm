import java.io.*;
import java.util.*;
public class j9328 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            char[][] map = new char[R][C];
            for(int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }
            LinkedList<Pair> bfs = new LinkedList<>();
            LinkedList<Pair> locked = new LinkedList<>();
            HashSet<Character> key = new HashSet<>();
            char[] keyTemp = br.readLine().toCharArray();
            for(char temp : keyTemp) {
                key.add(temp);
            }
            for(int i = 0; i < R; i++) {
                if(map[i][0] == '.' || map[i][0] == '$') {
                    bfs.add(new Pair(i, 0));
                }
                else if(Character.isLowerCase(map[i][0])) {
                    bfs.add(new Pair(i, 0));
                    key.add(map[i][0]);
                } 
                else if(Character.isUpperCase(map[i][0])) {
                    locked.add(new Pair(i, 0));
                }
                if(map[i][C - 1] == '.' || map[i][C - 1] == '$') {
                    bfs.add(new Pair(i, C - 1));
                }
                else if(Character.isLowerCase(map[i][C - 1])) {
                    bfs.add(new Pair(i, C - 1));
                    key.add(map[i][C - 1]);
                } 
                else if(Character.isUpperCase(map[i][C - 1])) {
                    locked.add(new Pair(i, C - 1));
                }
                
            }
            for(int j = 1; j < C - 1; j++) {
                if(map[0][j] == '.' || map[0][j] == '$') {
                    bfs.add(new Pair(0, j));
                }
                else if(Character.isLowerCase(map[0][j])) {
                    bfs.add(new Pair(0, j));
                    key.add(map[0][j]);
                } 
                else if(Character.isUpperCase(map[0][j])) {
                    locked.add(new Pair(0, j));
                }
                if(map[R - 1][j] == '.' || map[R - 1][j] == '$') {
                    bfs.add(new Pair(R - 1, j));
                }
                else if(Character.isLowerCase(map[R - 1][j])) {
                    bfs.add(new Pair(R - 1, j));
                    key.add(map[R - 1][j]);
                } 
                else if(Character.isUpperCase(map[R - 1][j])) {
                    locked.add(new Pair(R - 1, j));
                }
            }
            boolean[][] isVisited = new boolean[R][C];
            int ans = 0;
            while(true) {
                if(bfs.isEmpty()) {
                    LinkedList<Pair> save = new LinkedList<>();
                    while(!locked.isEmpty()) {
                        Pair temp = locked.poll();
                        if(key.contains(Character.toLowerCase(map[temp.r][temp.c]))) {
                            bfs.add(new Pair(temp.r, temp.c));
                        }
                        else {
                            save.add(temp);
                        }
                    }
                    while(!save.isEmpty()) {
                        locked.add(save.poll());
                    }
                }
                if(bfs.isEmpty()) {
                    break;
                }
                Pair now = bfs.poll();
                if(isVisited[now.r][now.c]) {
                    continue;
                }
                isVisited[now.r][now.c] = true;
                if(map[now.r][now.c] == '$') {
                    ans++;
                }
                for(int d = 0; d < 4; d++) {
                    int r2 = now.r + dr[d];
                    int c2 = now.c + dc[d];
                    if(r2 < 0 || r2 >= R || c2 < 0 || c2 >= C || isVisited[r2][c2] || map[r2][c2] == '*') {
                        continue;
                    }
                    if(Character.isUpperCase(map[r2][c2])) {
                        locked.add(new Pair(r2, c2));
                        continue;
                    }
                    if(Character.isLowerCase(map[r2][c2])) {
                        key.add(map[r2][c2]);
                    }
                    bfs.add(new Pair(r2, c2));
                }
            }
            sb.append(Long.toString(ans) + "\n");
        }
        System.out.println(sb.toString());
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
