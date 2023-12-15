import java.io.*;
import java.util.*;
public class j1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, S;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int p1 = 0;
        int p2 = 0;
        int ans = Integer.MAX_VALUE;
        int tempSum = arr[0];
        while(p1 <= p2) {
            if(tempSum >= S) {
                ans = Math.min(p2 - p1 + 1, ans);
                tempSum -= arr[p1];
                p1++;
            }
            else {
                p2++;
                if(p2 >= arr.length) break;
                tempSum += arr[p2];
            }
        }
        if(ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}
