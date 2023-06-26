import java.io.*;
public class j11050 {
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        arr = new int[11][11];
        for(int i=0; i<11; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            arr[i][1] = i;
        }
        System.out.println(comb(n, k));
    }
    public static int comb(int n, int k) {
        if(arr[n][k] > 0) {
            return arr[n][k];
        }
        else {
            arr[n][k] = comb(n-1, k-1) + comb(n-1, k);
            return arr[n][k];
        }
    }
}
