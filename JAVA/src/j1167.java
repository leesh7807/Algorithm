import java.io.*;
import java.util.*;
public class j1167 {
    // 답이 될 가능성이 있는 것들을 담는 최대 힙
    static PriorityQueue<Integer> res = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> tree = new ArrayList<>();
        for(int vertex=0; vertex<=V; vertex++) {
            tree.add(new ArrayList<Pair>());
        }
        for(int vertex=0; vertex<V; vertex++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree.get(u).add(new Pair(v, w));
            }
        }
        boolean[] isVisited = new boolean[V+1];
        isVisited[1] = true;
        dfs(1, 0, tree, isVisited);
        System.out.println(res.poll());
    }
    // 현재 노드 v를 탐색하는데 필요한 가중치 w + 리프노드까지 가장 큰 가중치로 탐색하는 경우 max1
    public static int dfs(int v, int w, ArrayList<ArrayList<Pair>> tree, boolean[] isVisited) {
        // 자식 노드 탐색 결과 저장 최대 힙
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(Pair p : tree.get(v)) {
            if(!isVisited[p.v]) {
                isVisited[p.v] = true;
                max.add(dfs(p.v, p.w, tree, isVisited));
                isVisited[p.v] = false;
            }
        }
        // 리프 노드 or 자식 노드 1개
        int max1 = max.isEmpty() ? 0 : max.poll();
        // 자식 노드가 2개 이상인 경우
        if(!max.isEmpty()) {
            int max2 = max.poll();
            res.add(max1 + max2);
        }
        // 리프 노드인 경우 max1 = 0
        res.add(max1 + w);
        return max1 + w;
    }
    static class Pair {
        int v, w;
        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
