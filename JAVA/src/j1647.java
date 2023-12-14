import java.io.*;
import java.util.*;
public class j1647 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] set = new int[N+1];
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            arr.add(new ArrayList<int[]>());
            set[i] = i;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arr.get(A).add(new int[]{B, C});
            arr.get(B).add(new int[]{A, C});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<int[]> road = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        for(int[] to : arr.get(1)) {
            pq.add(new int[]{to[0], to[1]});
        }
        while(!pq.isEmpty()) {
            int[] to = pq.poll();
            if(union(set, 1, to[0])) {
                for(int[] next : arr.get(to[0])) {
                    pq.add(new int[]{next[0], next[1]});
                }
                road.add(new int[]{to[0], to[1]});
            }
        }
        road.poll();
        int ans = 0;
        for(int[] usedRoad : road) {
            ans += usedRoad[1];
        }
        System.out.println(ans);
    }
    public static boolean union(int[] set, int a, int b) {
        int aRoot = find(set, a);
        int bRoot = find(set, b);
        if(aRoot == bRoot) return false;
        set[bRoot] = aRoot;
        return true;
    }
    public static int find(int[] set, int n) {
        if(set[n] != n) {
            set[n] = find(set, set[n]);
        }
        return set[n];
    }
}
