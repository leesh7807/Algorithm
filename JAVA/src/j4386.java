import java.io.*;
import java.util.*;
public class j4386 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double[][] stars = new double[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> {
            return Double.compare(a.dist, b.dist);
        });
        for(int i = 1; i < n; i++) {
            double dist = Math.sqrt(Math.pow(stars[i][0] - stars[0][0], 2) + Math.pow(stars[i][1] - stars[0][1], 2));
            q.add(new Pair(i, dist));
        }
        int[] set = new int[n];
        for(int i = 0; i < n; i++) {
            set[i] = i;
        }
        double ans = 0;
        while(!q.isEmpty()) {
            Pair candi = q.poll();
            if(union(set, 0, candi.u)) {
                ans += candi.dist;
                for(int i = 0; i < n; i++) {
                    if(i == candi.u) continue;
                    double dist = Math.sqrt(Math.pow(stars[i][0] - stars[candi.u][0], 2) + Math.pow(stars[i][1] - stars[candi.u][1], 2));
                    q.add(new Pair(i, dist));
                }
            }
        }
        System.out.println(ans);
    }
    static boolean union(int[] set, int u, int v) {
        int p1 = find(set, u);
        int p2 = find(set, v);
        if(p1 == p2) return false;
        set[p2] = p1;
        return true;
    }
    static int find(int[] set, int u) {
        if(set[u] != u) {
            set[u] = find(set, set[u]);
        }
        return set[u];
    }
    static class Pair {
        int u; 
        double dist;
        public Pair(int u, double dist) {
            this.u = u;
            this.dist = dist;
        }
    }
}
