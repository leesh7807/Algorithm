import java.io.*;
public class j2609 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int ans1 = gcd(n, m);
        System.out.println(ans1);
        System.out.print(n * m / ans1); // lcm(a, b) = a*b / gcd(a, b)
    }
    public static int gcd(int a, int b) { // 유클리드 호제법 gcd(a, b) == gcd(b, a%b);
        int r = a%b;
        if(r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}
