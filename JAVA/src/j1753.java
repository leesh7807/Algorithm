import java.util.*;
import java.io.*;
public class j1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vSize = Integer.parseInt(st.nextToken());
        int eSize = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        arr.add(new ArrayList<Pair>()); // 0에 더미
        for(int i=1; i<=vSize; i++) {
            arr.add(new ArrayList<Pair>());
        }
        int[] d = new int[vSize+1]; // 최소 거리 저장
        for(int i=1; i<=vSize; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        d[start] = 0;
        for(int i=0; i<eSize; i++) {
            st = new StringTokenizer(br.readLine());   
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Pair(v, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));
        while(!pq.isEmpty()) {
            Pair p = pq.poll(); // 제일 거리 가까운 경유지 선정
            if(d[p.n] < p.w) { // 큐에서 뽑아낸 노드가 이미 갱신된 노드인 경우
                continue;
            }
            for(Pair next : arr.get(p.n)) { // 인접 리스트에서 도착 노드 뽑아내기
                int newD = p.w + next.w; // 경유지까지 + 경유지에서 도착지
                // 경유지로 선정됐던 곳은 그 시점에 제일 가까운 곳.
                // 다른 곳을 거쳐 도착해도, 무조건 경유지로 바로 가는 것보다 거리가 길다.
                // 따라서 경유지로 선정 됐던 곳들은, 큐에 들어갈 일이 없다.
                if(newD < d[next.n]) {
                    d[next.n] = newD;
                    pq.add(new Pair(next.n, newD));
                }
            }
        }
        for(int i=1; i<=vSize; i++) {
            if(d[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            }
            else {
                bw.write(Long.toString(d[i]) + "\n");
            }
        }
        bw.close();
    }   
    static class Pair implements Comparable<Pair> {
        int n, w;
        Pair(int n, int w) {
            this.n = n;
            this.w = w;
        }
        @Override
        public int compareTo(Pair p) {
            if(this.w == p.w) {
                return Integer.compare(this.n, p.n);
            }
            return Integer.compare(this.w, p.w);
        }
    }
}
