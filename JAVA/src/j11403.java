import java.io.*;
import java.util.*;
public class j11403 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                if(st.nextToken().equals("1")) {
                    arr[i][j] = true;
                }
            }
        }
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][k] && arr[k][j]) arr[i][j] = true;
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j]) {
                    bw.write("1 ");
                }
                else {
                    bw.write("0 ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}
