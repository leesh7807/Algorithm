import java.io.*;
import java.util.*;
public class j6064 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int limit = lcm(M, N);
            int ans = x;
            int tempY = x;
            while(true) {
                tempY = tempY % N == 0 ? N : tempY % N;
                if(tempY == y) {
                    bw.write(Long.toString(ans) + "\n");
                    break;
                }
                if(ans > limit) {
                    bw.write("-1\n");
                    break;
                }
                tempY += M;
                ans += M;
            }
        }
        bw.close();
    }
    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
