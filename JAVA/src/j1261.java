import java.io.*;
import java.util.*;
public class j1261 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 열
        int m = Integer.parseInt(s[1]); // 행
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                map[i][j] = temp[j] - '0';
            }
        }
        int[][] visitTable = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visitTable[i][j] = Integer.MAX_VALUE;
            }
        }
        visitTable[0][0] = 0;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        while(!queue.isEmpty()) {
            Pair pos = queue.poll();
            for(int d = 0; d < 4; d++) {
                int tempR = pos.r + dr[d];
                int tempC = pos.c + dc[d];
                if(tempR < 0 || tempR >= m || tempC < 0 || tempC >= n) continue;
                if(map[tempR][tempC] + visitTable[pos.r][pos.c] < visitTable[tempR][tempC]) {
                    queue.add(new Pair(tempR, tempC));
                    visitTable[tempR][tempC] = map[tempR][tempC] + visitTable[pos.r][pos.c];
                }
            }
        }
        System.out.println(visitTable[m-1][n-1]);
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
