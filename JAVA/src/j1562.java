import java.io.*;
public class j1562 {
    static int div = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = (calcStairNum(0, 9, N) - calcStairNum(0, 8, N)) % div;
        ans = (ans - calcStairNum(1, 9, N)) % div;
        ans = (ans + calcStairNum(1, 8, N)) % div;
        if(ans < 0) ans += div;
        System.out.println(ans);
    }
    public static int calcStairNum(int start, int end, int N) {
        int[][] table = new int[end + 1][N + 1];
        for(int i = start; i <= end; i++) {
            if(i == 0) table[i][1] = 0;
            else table[i][1] = 1;
        }
        for(int n = 2; n <= N; n++) {
            for(int i = start; i <= end; i++) {
                if(i == start) 
                    table[i][n] = table[i+1][n-1];
                else if(i == end) 
                    table[i][n] = table[i-1][n-1];
                else {
                    table[i][n] = ((table[i+1][n-1] % div) + (table[i-1][n-1] % div)) % div;
                }
            }
        }
        int ret = 0;
        for(int i = start; i <= end; i++) {
            ret = (ret + table[i][N]) % div;
        }
        return ret;
    }
}
