import java.io.*;
import java.util.*;
public class j13460 {
    static int ans = Integer.MAX_VALUE;
    static int R, C;
    static char[][] rootMap;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        rootMap = new char[R][C];
        for(int i = 0; i < R; i++) {
            rootMap[i] = br.readLine().toCharArray();
        }
        Pair red = new Pair(-1, -1);
        Pair blue = new Pair(-1, -1);
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(rootMap[i][j] == 'R') {
                    red = new Pair(i ,j);
                }
                else if(rootMap[i][j] == 'B') {
                    blue = new Pair(i, j);
                }
            }
        }
        solve(rootMap, red, blue, 0);
        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
    }
    static void solve(char[][] map, Pair red, Pair blue, int cnt) {
        if(blue.isSink) return;
        if(red.isSink) {
            if(blue.isSink) return;
            else {
                ans = Math.min(ans, cnt);
                return;
            }
        }
        if(cnt == 10) {
            return;
        }
        for(int d = 0; d < 4; d++) {
            char[][] map2 = copy(map);
            Pair red2 = new Pair(red.r, red.c);
            Pair blue2 = new Pair(blue.r, blue.c);
            // 둘 다 한 번씩 굴린 후에 처음 굴린애를 한번 더 굴리면 동시에 굴린거랑 결과 같음.
            if(red2.r != 0) move(map2, red2, dr[d], dc[d]);
            if(red2.r != red.r || red2.c != red.c) {
                map2[red2.r][red2.c] = 'R';
                map2[red.r][red.c] = '.';
            }
            if(blue2.r != 0) move(map2, blue2, dr[d], dc[d]);
            if(blue2.r != blue.r || blue2.c != blue.c) {
                map2[blue2.r][blue2.c] = 'B';
                map2[blue.r][blue.c] = '.';
            }
            Pair temp = new Pair(red2.r, red2.c);
            if(red2.r != 0) move(map2, red2, dr[d], dc[d]);
            if(red2.r != temp.r || red2.c != temp.c) {
                map2[red2.r][red2.c] = 'R';
                map2[temp.r][temp.c] = '.';
            }
            solve(map2, red2, blue2, cnt + 1);
        }
    }
    static char[][] copy(char[][] map) {
        char[][] temp = new char[map.length][map[0].length];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
    static void move(char[][] map, Pair marble, int dr, int dc) {
        while(map[marble.r + dr][marble.c + dc] == '.' || map[marble.r + dr][marble.c + dc] == 'O') {
            marble.r += dr;
            marble.c += dc;
            if(map[marble.r][marble.c] == 'O') {
                marble.r = 0;
                marble.c = 0;
                marble.isSink = true;
                return;
            }
        }
    }
    static class Pair {
        int r, c;
        boolean isSink;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
            this.isSink = false;
        }
    }
}
