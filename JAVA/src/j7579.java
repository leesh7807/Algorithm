import java.io.*;
import java.util.*;
public class j7579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringTokenizer bytesTokens = new StringTokenizer(br.readLine());
        StringTokenizer costTokens = new StringTokenizer(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        int maxCost = 0;
        for(int i = 0; i < N; i++) {
            int tempBytes = Integer.parseInt(bytesTokens.nextToken());
            int tempCost = Integer.parseInt(costTokens.nextToken());
            maxCost += tempCost;
            list.add(new Pair(tempBytes, tempCost));
        }
        list.sort((a, b) -> {
            if(a.cost == b.cost) return Integer.compare(b.bytes, a.bytes);
            return Integer.compare(a.cost, b.cost);
        });
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[list.size() + 1][maxCost + 1];
        for(int i = 1; i <= list.size(); i++) {
            for(int j = 0; j <= maxCost; j++) {
                Pair now = list.get(i - 1);
                dp[i][j] = dp[i - 1][j];
                if(now.cost > j) {
                    continue;
                }
                dp[i][j] = Math.max(now.bytes + dp[i - 1][j - now.cost], dp[i][j]);
                // 현재 비용으로 필요 메모리 확보 가능하면
                if(dp[i][j] >= M) {
                    ans = Math.min(j, ans);
                }
            }
        }
        System.out.println(ans);
    }
    static class Pair {
        int bytes, cost;
        public Pair(int bytes, int cost) {
            this.bytes = bytes;
            this.cost = cost;
        }
    }
}
