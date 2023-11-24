import java.io.*;
import java.util.*;
public class j1197 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for(int v = 0; v <= vertex; v++) {
            arr.add(new ArrayList<Pair>());
        }
        for(int e = 0; e < edge; e++) {
            st = new StringTokenizer(br.readLine());
            int tempVertex1 = Integer.parseInt(st.nextToken());
            int tempVertex2 = Integer.parseInt(st.nextToken());
            int tempWeight = Integer.parseInt(st.nextToken());
            arr.get(tempVertex1).add(new Pair(tempVertex2, tempWeight));
            arr.get(tempVertex2).add(new Pair(tempVertex1, tempWeight));
        }
        int[] set = new int[vertex + 1];
        for(int i = 1; i <= vertex; i++) {
            set[i] = i;
        }
        int answer = 0;
        PriorityQueue<Pair> linkedNodes = new PriorityQueue<>((Pair a, Pair b) -> {return Integer.compare(a.weight, b.weight);});
        for(Pair p : arr.get(1)) {
            linkedNodes.add(p);
        }
        while(!linkedNodes.isEmpty()) {
            Pair nearNode = linkedNodes.poll();
            if(union(set, 1, nearNode.node)) {
                answer += nearNode.weight;
                for(Pair newNearNode : arr.get(nearNode.node)) {
                    linkedNodes.add(newNearNode);
                }
            }
        }
        System.out.println(answer);
    }
    static boolean union(int[] set, int n1, int n2) {
        int p1 = find(set, n1);
        int p2 = find(set, n2);
        if(p1 == p2) {
            return false;
        }
        set[p2] = p1;
        return true;
    }
    static int find(int[] set, int n) {
        if(set[n] != n) {
            set[n] = find(set, set[n]);
        }
        return set[n];
    }
    static class Pair{
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
