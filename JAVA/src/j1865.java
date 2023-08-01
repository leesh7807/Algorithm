import java.util.*;
import java.io.*;
public class j1865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
            for(int i=0; i<N+1; i++) {
                arr.add(new ArrayList<Pair>());
            }
            for(int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                arr.get(from).add(new Pair(to, cost));
                arr.get(to).add(new Pair(from, cost));
            }
            for(int w=0; w<W; w++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                arr.get(from).add(new Pair(to, -cost));
            }
            // 시작노드가 정해지지 않은 상황에서 음의 루프가 있는지 판단하는 문제
            // 0을 시작노드로 해서 모든 노드를 0의 가중치로 이었다
            for(int i=0; i<N+1; i++) {
                arr.get(0).add(new Pair(i, 0));
            }
            int[] dist = new int[N+1];
            for(int i=0; i<dist.length; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[0] = 0;
            boolean negLoopFlag = false; 
            // 0과 모든 노드가 이어져있으므로 외딴섬이 있더라도 탐색하게 되고, 벨만-포드로 음의 루프를 찾을 수 있다.
            for(int n=0; n<=N+1; n++) {
                for(int i=0; i<arr.size(); i++) {
                    for(Pair p : arr.get(i)) {
                        int from = i;
                        int to = p.v;
                        int cost = p.d;
                        if(dist[from] + cost < dist[to]) {
                            dist[to] = dist[from] + cost;
                            if(n == N+1) negLoopFlag = true;
                        }
                    }
                }
            }
            if(negLoopFlag) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.close();
    }
    static class Pair {
        int v, d;
        public Pair(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
}
