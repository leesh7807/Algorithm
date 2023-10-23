import java.io.*;
import java.util.*;
public class j2294_dp {
    static int max = 1234567891;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashSet<Integer> coinList = new HashSet<>();
        for(int i=0; i<n; i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }
        int[] dp = new int[k+1];
        for(int i=1; i<=k; i++) {
            int temp = max;
            for(int coin : coinList) {
                if(i - coin < 0) continue;
                temp = Math.min(temp, dp[i-coin] + 1);
            }
            dp[i] = temp;
        }   
        int ans = dp[k] == max ? -1 : dp[k];
        System.out.println(ans);
    }
}
