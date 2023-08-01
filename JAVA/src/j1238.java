import java.io.*;
import java.util.*;
public class j1238 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int r=1; r<N+1; r++) {
            for(int c=1; c<N+1; c++) {
                arr[r][c] = 1000000;
            }
        }
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u][v] = w;
        }
        PriorityQueue<Pair> go = new PriorityQueue<>((Pair a, Pair b) -> Integer.compare(a.w, b.w));
        PriorityQueue<Pair> come = new PriorityQueue<>((Pair a, Pair b) -> Integer.compare(a.w, b.w));
        int[] toX = new int[N+1];
        int[] xTo = new int[N+1];
        for(int n=0; n<N+1; n++) {
            toX[n] = Integer.MAX_VALUE;
            xTo[n] = Integer.MAX_VALUE;
        }
        go.add(new Pair(X, 0));
        come.add(new Pair(X, 0));
        toX[X] = 0;
        xTo[X] = 0;
        while(!go.isEmpty()) {
            Pair p = go.poll();
            int now = p.v;
            int dist = p.w;
            if(toX[now] < dist) continue;
            for(int prev=1; prev<N+1; prev++) {
                int newDist = arr[prev][now] + dist;
                if(newDist < toX[prev]) {
                    go.add(new Pair(prev, newDist));
                    toX[prev] = newDist;
                }
            }
        }
        while(!come.isEmpty()) {
            Pair p = come.poll();
            int now = p.v;
            int dist = p.w;
            if(xTo[now] < dist) continue;
            for(int next=1; next<N+1; next++) {
                int newDist = dist + arr[now][next];
                if(newDist < xTo[next]) {
                    come.add(new Pair(next, newDist));
                    xTo[next] = newDist;
                }
            }
        }
        int ans = 0;
        for(int i=1; i<N+1; i++) {
            ans = Math.max(ans, toX[i] + xTo[i]);
        }
        System.out.println(ans);
    }
    static class Pair {
        int v, w;
        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
