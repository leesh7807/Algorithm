import java.io.*;
import java.util.*;
public class j1504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for(int n=0; n<N+1; n++) {
            arr.add(new ArrayList<Pair>());   
        }
        for(int e=0; e<E; e++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Pair(v, w));
            arr.get(v).add(new Pair(u, w));
        }
        st = new StringTokenizer(br.readLine());
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());
        int[] distStart = new int[N+1];
        dijkstra(1, distStart, arr);
        int[] distMid1 = new int[N+1];
        dijkstra(mid1, distMid1, arr);
        int[] distMid2 = new int[N+1];
        dijkstra(mid2, distMid2, arr);
        long ans1 = (long)distStart[mid1] + (long)distMid1[mid2] + (long)distMid2[N];
        long ans2 = (long)distStart[mid2] + (long)distMid2[mid1] + (long)distMid1[N];
        long ans = Math.min(ans1, ans2);
        if(ans >= Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    public static void dijkstra(int start, int[] dist, ArrayList<ArrayList<Pair>> arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> Integer.compare(a.w, b.w));
        for(int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new Pair(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int now = p.v;
            int startToNow = p.w;
            if(startToNow > dist[now]) continue;
            for(Pair next : arr.get(now)) {
                int newDist = startToNow + next.w;
                if(newDist < dist[next.v]) {
                    pq.add(new Pair(next.v, newDist));
                    dist[next.v] = newDist;
                }
            }
        }
    }
    static class Pair {
        int v, w;
        public Pair (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
