import java.io.*;
import java.util.*;
public class j1351 {
    static HashMap<Long, Long> cache = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N, P, Q;
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        long ans = divide(N, P, Q);
        if(N == 0) System.out.println(1);
        else System.out.println(ans);
    }
    public static long divide(long N, long P, long Q) {
        long p = N / P;
        long q = N / Q;
        if(p == 0 && q == 0) return 2;
        else if(p == 0) {
            long temp = cache.containsKey(q) ? cache.get(q) : divide(q, P, Q);
            cache.put(q, temp);
            return 1 + temp;
        }
        else if(q == 0) {
            long temp = cache.containsKey(p) ? cache.get(p) : divide(p, P, Q);
            cache.put(p, temp);
            return 1 + temp;
        }
        else {
            long temp1 = cache.containsKey(q) ? cache.get(q) : divide(q, P, Q);
            long temp2 = cache.containsKey(p) ? cache.get(p) : divide(p, P, Q);
            cache.put(q, temp1);
            cache.put(p, temp2);
            return temp1 + temp2;
        }
    }
}
