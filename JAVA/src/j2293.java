import java.io.*;
import java.util.*;
public class j2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> coinList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(Integer coin : coinList) {
            for(int i=coin; i<=k; i++) {
                dp[i] += dp[i-coin];
            }
        }
        System.out.println(dp[k]);
    }
}
