import java.io.*;
import java.util.*;
public class j11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] treeParent = new int[N+1];
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int n=0; n<N+1; n++) {
            tree.add(new ArrayList<>());
        }
        for(int n=0; n<N-1; n++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];
        queue.add(1);
        isVisited[1] = true;
        while(!queue.isEmpty()) {
            int parent = queue.poll();
            for(Integer child : tree.get(parent)) {
                if(isVisited[child]) continue;
                treeParent[child] = parent;
                queue.add(child);
                isVisited[child] = true;
            }
        }
        for(int n=2; n<N+1; n++) {
            bw.write(Long.toString(treeParent[n]) + "\n");
        }
        bw.close();
    }
}