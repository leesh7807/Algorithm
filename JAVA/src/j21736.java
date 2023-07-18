import java.io.*;
import java.util.*;
public class j21736 {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] map = new int[N][M];
        LinkedList<Pair> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        for(int n=0; n<N; n++) {
            char[] temp = br.readLine().toCharArray();
            for(int m=0; m<M; m++) {
                switch(temp[m]) {
                    case 'O' :
                        map[n][m] = 0;
                        break;
                    case 'P' :
                        map[n][m] = 1;
                        break;
                    case 'X' :
                        map[n][m] = -1;
                        break;
                    case 'I' :
                        map[n][m] = 0;
                        q.add(new Pair(n, m)); 
                        isVisited[n][m] = true;
                        break;
                }
            }
        }
        int people = 0;
        while(!q.isEmpty()) {
            Pair now = q.poll();
            int r = now.r;
            int c = now.c;
            for(int d=0; d<4; d++) {
                int r2 = r + dy[d];
                int c2 = c + dx[d];
                if(r2>=0 && r2<N && c2>=0 && c2<M && map[r2][c2]>=0 && !isVisited[r2][c2]) {
                    q.add(new Pair(r2, c2));
                    isVisited[r2][c2] = true;
                    if(map[r2][c2]==1) {
                        people++;
                    }
                }
            }
        }
        String ans = people==0 ? "TT" : Long.toString(people);
        System.out.println(ans);
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}