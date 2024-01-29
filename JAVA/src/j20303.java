import java.io.*;
import java.util.*;
public class j20303 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, K;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] candy = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ArrayList<Pair> group = new ArrayList<>();
        boolean[] isVisited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            // 새로운 그룹 발견
            if(!isVisited[i]) {
                int kids = 0;
                int candies = 0;
                LinkedList<Integer> q = new LinkedList<>();
                isVisited[i] = true;
                q.add(i);
                while(!q.isEmpty()) {
                    int kid = q.poll();
                    kids++;
                    candies += candy[kid];
                    for(int friend : graph.get(kid)) {
                        if(!isVisited[friend]) {
                            isVisited[friend] = true;                            
                            q.add(friend);
                        }
                    }
                }
                group.add(new Pair(kids, candies));
            }
        }
        // K명 최대 사탕 = max(K - kids 최대 사탕 + candies, 새로운 그룹 추가 x)
        int[][] dp = new int[group.size() + 1][K];
        for(int i = 0; i < group.size(); i++) {
            Pair g = group.get(i);
            int kids = g.kids;
            int candies = g.candies;
            for(int k = 1; k < K; k++) {
                if(kids > k) dp[i + 1][k] = dp[i][k];
                else {
                    dp[i + 1][k] = Math.max(dp[i][k - kids] + candies, dp[i][k]);
                } 
            }
        }
        System.out.println(dp[group.size()][K - 1]);
    }
    static class Pair {
        int kids, candies;
        public Pair(int kids, int candies) {
            this.kids = kids;
            this.candies = candies;
        }
    }
}
