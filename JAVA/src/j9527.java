import java.io.*;
import java.util.*;
public class j9527 {
    static HashMap<Long, Long> cache = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(sum(b) - sum(a - 1));
    }
    static long sum(long n) {
        if(n == 0) {
            return 0L;
        }
        if(n == 1) {
            return 1L;
        }
        long temp = 1;
        while(temp * 2 <= n) {
            temp *= 2;
        }
        long ret1 = 0L;
        long ret2 = 0L;
        if(cache.containsKey(temp - 1)) {
            ret1 = cache.get(temp - 1);
        }
        else {
            ret1 = sum(temp - 1);
            cache.put(temp - 1, ret1);
        }
        if(cache.containsKey(n - temp)) {
            ret2 = cache.get(n - temp);
        }
        else {
            ret2 = sum(n - temp);
            cache.put(n - temp, ret2);
        }
        long ret = ret1 + ret2 + n - temp + 1;
        return ret;
    }
}

// 0 1 / 1 2 / 1 2 2 3 / 1 2 2 3 2 3 3 4  