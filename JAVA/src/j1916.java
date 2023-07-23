import java.io.*;
import java.util.*;
public class j1916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for(int n=0; n<=N; n++) {
            arr.add(new ArrayList<Pair>());
        }
        StringTokenizer st;
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Pair(v, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] d = new int[N+1];
        for(int i=0; i<=N; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> Integer.compare(a.w, b.w));
        pq.add(new Pair(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int now = p.v;
            int startToNow = p.w;
            if(startToNow > d[now]) continue;
            for(Pair q : arr.get(now)) {
                int next = q.v;
                int nowToNext = q.w;
                int newD = startToNow + nowToNext;
                if(newD >= d[next]) continue;
                pq.add(new Pair(next, newD));
                d[next] = newD;
            }
        }
        System.out.println(d[end]);
    }
    static class Pair {
        int v, w;
        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
