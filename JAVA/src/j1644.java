import java.io.*;
import java.util.*;
public class j1644 {
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(0);
            return;
        }
        int[] tempPrime = new int[N+1];
        for(int i = 2; i <= N; i++) {
            for(int j = i; j <= N; j += i) {
                tempPrime[j]++;
            }
        }
        for(int i = 2; i <= N; i++) {
            if(tempPrime[i] == 1) {
                prime.add(i);
            }
        }
        long[] nSum = new long[prime.size()];
        nSum[0] = prime.get(0);
        for(int i = 1; i < prime.size(); i++) {
            nSum[i] = nSum[i-1] + prime.get(i);
        }
        int ans = 0;
        for(int i = nSum.length - 1; i >= 0; i--) {
            long target = nSum[i] - N;
            if(target == 0) {
                ans++;
                break;
            }
            if(target < 0) break;
            int lo = -1;
            int hi = i + 1;
            while(lo + 1 < hi) {
                int mid = (lo + hi) / 2;
                if(target <= nSum[mid]) {
                    hi = mid;
                }
                else if(target > nSum[mid]) {
                    lo = mid;
                }
            }
            if(hi > nSum.length - 1) continue;
            if(target == nSum[hi]) ans++;
        }
        System.out.println(ans);
    }
}
