import java.io.*;
import java.util.*;
public class j10830 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] ans = matrixSqrt(arr, B);
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans.length; j++) {
                bw.write(Long.toString(ans[i][j] % 1000) + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
    public static int[][] matrixSqrt(int[][] A, long exp) {
        if(exp == 1) {
            return A;
        }
        if(exp % 2 == 0) {
            int[][] temp = matrixSqrt(A, exp/2);
            int[][] ret = new int[temp.length][temp.length];
            for(int i=0; i<ret.length; i++) {
                for(int j=0; j<ret.length; j++) {
                    for(int k=0; k<ret.length; k++) {
                        ret[i][j] += (temp[i][k] % 1000) * (temp[k][j] % 1000) % 1000;
                        ret[i][j] %= 1000;
                    }
                }
            }
            return ret;
        }
        else {
            int[][] temp = matrixSqrt(A, exp/2);
            int[][] ret = new int[temp.length][temp.length];
            for(int i=0; i<ret.length; i++) {
                for(int j=0; j<ret.length; j++) {
                    for(int k=0; k<ret.length; k++) {
                        ret[i][j] += (temp[i][k] % 1000) * (temp[k][j] % 1000) % 1000;
                        ret[i][j] %= 1000;
                    }
                }
            }
            int[][] ret2 = new int[temp.length][temp.length];
            for(int i=0; i<ret.length; i++) {
                for(int j=0; j<ret.length; j++) {
                    for(int k=0; k<ret.length; k++) {
                        ret2[i][j] += (ret[i][k] % 1000) * (A[k][j] % 1000) % 1000;
                        ret2[i][j] %= 1000;
                    }
                }
            }
            return ret2;
        }
    }
}
