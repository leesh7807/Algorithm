import java.io.*;
import java.util.*;
public class j10026 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1}; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans1 = 0;
        int ans2 = 0;
        char[][] arr = new char[N][N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        LinkedList<Pair> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    char stand = arr[i][j];
                    q.add(new Pair(i, j));
                    isVisited[i][j] = true;
                    while(!q.isEmpty()) {
                        Pair now = q.poll();
                        int r = now.r;
                        int c = now.c;
                        for(int d=0; d<4; d++) {
                            int r2 = r + dx[d];
                            int c2 = c + dy[d];
                            if(r2>=0 && r2<N && c2>=0 && c2<N && arr[r2][c2]==stand && !isVisited[r2][c2]) {
                                q.add(new Pair(r2, c2));
                                isVisited[r2][c2] = true;
                            } 
                        }
                    }
                    ans1++;
                }
            }
        }
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    char stand = arr[i][j];
                    q.add(new Pair(i, j));
                    isVisited[i][j] = true;
                    while(!q.isEmpty()) {
                        Pair now = q.poll();
                        int r = now.r;
                        int c = now.c;
                        for(int d=0; d<4; d++) {
                            int r2 = r + dx[d];
                            int c2 = c + dy[d];
                            if(r2>=0 && r2<N && c2>=0 && c2<N && !isVisited[r2][c2]) {
                                if(stand=='B' && arr[r2][c2]==stand) {
                                    q.add(new Pair(r2, c2));
                                    isVisited[r2][c2] = true;
                                }
                                else if(stand!='B' && arr[r2][c2]!='B') {
                                    q.add(new Pair(r2, c2));
                                    isVisited[r2][c2] = true;
                                }
                            } 
                        }
                    }
                    ans2++;
                }
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
