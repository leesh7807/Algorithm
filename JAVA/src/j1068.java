import java.io.*;
import java.util.*;
public class j1068 {
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] isVisited;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();
        for(int i=0; i<n; i++) {
            tree.add(new ArrayList<Integer>());
        }
        int root = -1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }
            tree.get(i).add(parent);
            tree.get(parent).add(i);
        }
        st = new StringTokenizer(br.readLine());
        int deleted = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];
        isVisited[deleted] = true;
        if(isVisited[root]) {
            System.out.println(0);
            return;
        }
        dfs(root);
        System.out.println(count);
    }
    static void dfs(int node) {
        isVisited[node] = true;
        boolean isLeaf = true;
        for(Integer i : tree.get(node)) {
            if(!isVisited[i]) {
                isLeaf = false;
                dfs(i);
            }
        }
        if(isLeaf) count++;
    }
}