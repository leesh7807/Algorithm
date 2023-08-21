import java.io.*;
import java.util.*;
public class j11054 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        int[] inc = new int[N];
        int[] desc = new int[N];
        for(int i=0; i<N; i++) {
            int temp = 0;
            for(int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i]) {
                    temp = Math.max(inc[j], temp);
                }
            }
            inc[i] = temp + 1;
        }
        for(int i=N-1; i>=0; i--) {
            int temp = 0;
            for(int j=i+1; j<N; j++) {
                if(arr[j] < arr[i]) {
                    temp = Math.max(desc[j], temp);
                }
            }
            desc[i] = temp + 1;
        }
        int ans = 0;
        for(int i=0; i<N; i++) {
            ans = Math.max(ans, inc[i] + desc[i] - 1);
        }
        System.out.println(ans);
    }
}
