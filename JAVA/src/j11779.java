import java.io.*;
import java.util.*;
public class j11779 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<Pair>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(from).add(new Pair(to, weight));
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> Integer.compare(a.weight, b.weight));
        int[] dist = new int[n+1];
        for(int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new Pair(A, 0));
        dist[A] = 0;
        int[] path = new int[n+1];
        while(!pq.isEmpty()) {
            Pair now = pq.poll();
            int mid = now.destination;
            int beginToMid = now.weight;
            if(dist[mid] < beginToMid) continue;
            for(Pair p : arr.get(mid)) {
                int destination = p.destination;
                int midToDest = p.weight;
                int newDist = beginToMid + midToDest;
                if(dist[destination] > newDist) {
                    pq.add(new Pair(destination, newDist));
                    dist[destination] = newDist;
                    path[destination] = mid;
                }
            }
        }
        bw.write(Long.toString(dist[B]) + "\n");
        LinkedList<Integer> route = new LinkedList<>();
        int mid = path[B];
        while(mid != A) {
            route.addFirst(mid);
            mid = path[mid];
        }
        route.addFirst(A);
        route.addLast(B);
        bw.write(Long.toString(route.size()) + "\n");
        for(Integer i : route) {
            bw.write(Long.toString(i) + " ");
        }
        bw.write("\n");
        bw.close();
    }
    public static class Pair{
        int destination, weight;
        public Pair(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
