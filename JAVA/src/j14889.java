import java.util.*;
import java.io.*;
public class j14889 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
    }
    public static void comb(int depth) {
        
    }
}

/* 20C10 * 20^2 브루트포스 시간복잡도 
 * 조합 연산할 때 20Cn 정도가 대충 18만이라고 어림짐작
 * 거기서부터 1커질때마다 대충 2배씩 뛴다고 생각하면 될듯.
 * 20만 * 400는 8천만 정도.
*/