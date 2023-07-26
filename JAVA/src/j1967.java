import java.util.*;
import java.io.*;
class j1967 {
    static PriorityQueue<Integer> ans = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> tree = new ArrayList<>();
        for(int n=0; n<N+1; n++) {
            tree.add(new ArrayList<Pair>());
        }
        for(int n=0; n<N-1; n++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(parent).add(new Pair(child, weight));
        }
        boolean[] isVisited = new boolean[N+1];
        dfs(1, 0, tree, isVisited);
        System.out.println(ans.poll());
    }
    public static int dfs(int parent, int weight, ArrayList<ArrayList<Pair>> tree, boolean[] isVisited) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(Pair child : tree.get(parent)) {
            if(isVisited[child.node]) continue;
            isVisited[child.node] = true;
            maxHeap.add(dfs(child.node, child.weight, tree, isVisited));
            isVisited[child.node] = false;
        }
        // 리프 노드
        if(maxHeap.isEmpty()) {
            ans.add(weight);
            return weight;
        }
        int first = maxHeap.poll();
        // 노드 하나
        if(maxHeap.isEmpty()) {
            ans.add(first + weight);
        }
        // 노드 두개 이상
        else {
            int second = maxHeap.poll();
            ans.add(first + second);
        }
        return first + weight;
    }
    static class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}