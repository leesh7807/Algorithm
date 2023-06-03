import java.util.*;
import java.io.*;
public class j15591 {
    static int n;
    static ArrayList<ArrayList<Pair>> arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new ArrayList<ArrayList<Pair>>();
        arr.add(new ArrayList<Pair>(Arrays.asList(new Pair(0, 0)))); // 0번째 비디오에 더미 값.
        for(int i=0; i<n; i++) { // arr 초기화.
            arr.add(new ArrayList<Pair>());
        }
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(r).add(new Pair(c, w));
            arr.get(c).add(new Pair(r, w));
        }
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int video = bfsSearch(k, v);
            bw.write(Long.toString(video) + "\n");
        }
        bw.close();   
    }
    public static int bfsSearch(int k, int v) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        q.add(v);
        isVisited[v] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Pair p : arr.get(now)) {
                if(!isVisited[p.d] && p.w >= k) {
                    isVisited[p.d] = true;
                    q.add(p.d);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static class Pair {
        int d, w;
        Pair(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
}

/* 인접행렬에서 dfs or bfs시 시간복잡도는 V^2
 * 인접리스트에서 시간복잡도는 V+E.
 * 무방향 그래프에서 간선의 최대 개수는 n*(n-1)/2. 
 * 이 문제의 경우 간선의 최대 개수는 n-1로 고정되어있음.
 * 인접 행렬로 풀 경우 5000(정점) * 5000(간선) * 5000(질문).
 * 인접 리스트로 풀 경우 ( 5000(정점) + 5000(간선) ) * 5000(질문). 
*/