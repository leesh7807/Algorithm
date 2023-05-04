import java.io.*;
import java.util.*;

public class j2193 {
    static long[] cache = new long[91];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        cache[1] = 1;
        cache[2] = 1;
        bw.write(String.valueOf(fibo(N)));
        bw.close();
    }   
    public static long fibo(int n) {
        if(cache[n] > 0) {
            return cache[n];
        }
        else {
            cache[n] = fibo(n-1) + fibo(n-2);
            return cache[n];
        }
    } 
}