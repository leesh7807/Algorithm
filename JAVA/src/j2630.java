import java.io.*;
import java.util.*;
public class j2630 {
    static int white, blue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutting(N, 0, 0, arr);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void cutting(int n, int r, int c, int[][] arr) {
        boolean wCheck = true;
        boolean bCheck = true;
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(arr[i][j] == 0) {
                    bCheck = false;
                }
                else if(arr[i][j] == 1) {
                    wCheck = false;
                }
            }
        }
        if(wCheck) {
            white++;
            return;
        }
        else if(bCheck) {
            blue++;
            return;
        }
        else {
            int m = n/2;
            cutting(m, r, c, arr);
            cutting(m, r+m, c, arr);
            cutting(m, r, c+m, arr);
            cutting(m, r+m, c+m, arr);
        }
    }
}
