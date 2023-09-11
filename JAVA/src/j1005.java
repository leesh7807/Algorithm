import java.io.*;
import java.util.*;
public class j1005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] delay = new int[N+1];
            for(int i=1; i<N+1; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0; i<N+1; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
            }
            ACMCraft acmCraft = new ACMCraft(graph, delay);
            int ans = acmCraft.getConstructionTime(Integer.parseInt(br.readLine()));
            bw.write(Long.toString(ans) + "\n");
        }
        bw.close();
    }
    static class ACMCraft {
        ArrayList<ArrayList<Integer>> graph;
        int[] delay;
        Integer[] caching;
        boolean[] isVisited;
        public ACMCraft(ArrayList<ArrayList<Integer>> graph, int[] delay) {
            this.graph = graph;
            this.delay = delay;
            isVisited = new boolean[delay.length];
            caching = new Integer[delay.length];
        }
        public int getConstructionTime(int start) {
            return retrieveNode(start);
        }
        private int retrieveNode(int node) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {return Integer.compare(b, a);});
            for(Integer i : graph.get(node)) {
                isVisited[i] = true;
                if(caching[i] != null) {
                    maxHeap.add(caching[i]);
                }
                else {
                    int temp = retrieveNode(i);
                    maxHeap.add(temp);
                    caching[i] = temp;
                }
                isVisited[i] = false;
            }
            if(maxHeap.isEmpty()) {
                return delay[node];
            }
            else {
                return delay[node] + maxHeap.poll();
            }
        }
    }
}
