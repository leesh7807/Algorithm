import java.io.*;
import java.util.*;
public class j2252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int[] topology = new int[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(parent).add(child);
            topology[child]++;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(topology[i]  == 0) 
                q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int v = q.poll();
            sb.append(Long.toString(v) + " ");
            for(Integer child : graph.get(v)) {
                if(--topology[child] == 0) 
                    q.add(child);
            }
        }
        System.out.println(sb.toString());
    }
}
