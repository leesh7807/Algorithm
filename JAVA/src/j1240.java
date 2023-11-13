import java.io.*;
import java.util.*;
public class j1240 {
    static ArrayList<ArrayList<Pair>> tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            tree.add(new ArrayList<Pair>());
        }
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            tree.get(from).add(new Pair(to, dist));
            tree.get(to).add(new Pair(from, dist));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            boolean[] isVisited = new boolean[n+1];
            isVisited[from] = true;
            sb.append(Long.toString(dfs(from, from, to, 0, isVisited)) + "\n");
        }
        System.out.println(sb.toString());
    }
    static public int dfs(int now, int from, int to, int dist, boolean[] isVisited) {
        if(now == to) {
            return dist;
        }
        int ret = Integer.MAX_VALUE;
        for(Pair next : tree.get(now)) {
            int nextNode = next.n;
            int nextDist = next.d;
            if(isVisited[nextNode]) continue;
            isVisited[nextNode] = true;
            ret = Math.min(dfs(nextNode, from, to, dist+nextDist, isVisited), ret);
        }
        return ret;
    }
    static class Pair {
        int n, d; 
        public Pair(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}
