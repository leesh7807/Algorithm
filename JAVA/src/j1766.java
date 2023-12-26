import java.io.*;
import java.util.*;
public class j1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            graph.get(first).add(after);
            inDegree[after]++;
        }
        StringBuilder ans = new StringBuilder();
        PriorityQueue<Integer> topology = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) topology.add(i);
        }
        for(int i = 1; i <= N; i++) {
            if(topology.isEmpty()) {
                System.out.println("loop");
                return;
            }
            int task = topology.poll();
            ans.append(Long.toString(task) + " ");
            for(Integer after : graph.get(task)) {
                if(--inDegree[after] == 0) topology.add(after);
            }
        }
        System.out.println(ans.toString());
    }
}
