import java.io.*;
import java.util.*;
public class j1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수
        PriorityQueue<Pair> massLowFirst = new PriorityQueue<>((a, b) -> {return Integer.compare(a.m, b.m);});
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            massLowFirst.add(new Pair(M, V));
        }
        PriorityQueue<Integer> bag = new PriorityQueue<>();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            bag.add(C);
        }
        long answer = 0L;
        PriorityQueue<Pair> valueHighFirst = new PriorityQueue<>((a, b) -> {return Integer.compare(b.v, a.v);});
        while(!bag.isEmpty()) {
            int maxWeight = bag.poll();
            while(!massLowFirst.isEmpty() && massLowFirst.peek().m <= maxWeight) {
                valueHighFirst.add(massLowFirst.poll());
            }
            if(!valueHighFirst.isEmpty()) answer += valueHighFirst.poll().v;
        }
        System.out.println(answer);
    }
    static class Pair {
        int m, v;
        public Pair(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
