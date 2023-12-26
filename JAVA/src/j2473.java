import java.io.*;
import java.util.*;
public class j2473 {
    static final long INF = 100_0000_0000L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Long> arr = new ArrayList<>(5000);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }
        arr.sort(null);
        long mostNearZero = INF;
        long[] ans = new long[3];
        // 두 용액을 선택하는 모든 케이스
        for(int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            for(int j = i + 1; j < arr.size(); j++) {
                long b = arr.get(j);
                // 이분 탐색
                long target = -a + (-b);
                int lo = j;
                int hi = arr.size();
                while(lo + 1 < hi) {
                    int mid = (lo + hi) / 2;
                    if(arr.get(mid) < target) {
                        lo = mid;
                    }
                    else if(arr.get(mid) >= target) {
                        hi = mid;
                    }
                }
                long c1 = INF;
                long c2 = INF;
                if(lo > j)
                    c1 = arr.get(lo);
                if(hi < arr.size())
                    c2 = arr.get(hi);
                long c = Math.abs(a + b + c1) < Math.abs(a + b + c2) ? c1 : c2;
                if(Math.abs(a + b + c) < Math.abs(mostNearZero)) {
                    mostNearZero = a + b + c;
                    ans[0] = a;
                    ans[1] = b;
                    ans[2] = c;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(Long.toString(ans[0]) + " " + Long.toString(ans[1]) + " " + Long.toString(ans[2]));
    }
}
