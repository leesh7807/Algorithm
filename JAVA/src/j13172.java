import java.io.*;
import java.util.*;
public class j13172 {
    static long mod = 1000000007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long M = Long.parseLong(st.nextToken());
        long ans = 0L;
        for(long i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long nRev = pow(n, mod-2);
            ans = (ans + (s * nRev) % mod) % mod;
        }
        System.out.println(ans);
    }
    static public long pow(long n, long exp) {
        if(exp == 1) {
            return n;
        }
        long operand = pow(n, exp/2) % mod;
        if(exp%2 == 0) {
            return (operand % mod) * (operand % mod) % mod;
        }
        else {
            return ((operand % mod) * (operand % mod) % mod) * n % mod ;
        }
    }
}
