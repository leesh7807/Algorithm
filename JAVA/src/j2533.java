import java.util.*;
import java.io.*;
public class j2533 {
    static ArrayList<ArrayList<Integer>> e;
    static Integer[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        e = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            e.add(new ArrayList<Integer>());
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            e.get(u).add(v);
            e.get(v).add(u);
        }
        dp = new Integer[N+1][2];
        dfs(1);
        bw.write(Long.toString(Math.min(dp[1][0], dp[1][1]))); // 루트 노드가 얼리어답터인 경우와 아닌 경우 중 작은 것.
        bw.close();
    }
    public static void dfs(int n) { // 서브트리내 모든 얼리어답터 케이스(0, 1)를 테이블에 기록하며 합산
        dp[n][0] = 0;
        dp[n][1] = 1; // 얼리어답터
        for(Integer i : e.get(n)) {
            if(dp[i][0] == null) { // 최초 방문
                dfs(i);
                dp[n][0] += dp[i][1]; // 부모노드가 아닌 경우 자식노드는 모두 얼리어답터
                dp[n][1] += Math.min(dp[i][0], dp[i][1]); // 부모노드가 얼리어답터인 경우 자식노드가 얼리어답터인 경우와 아닌 경우 중 작은 것.
            }
        }
    }
}
