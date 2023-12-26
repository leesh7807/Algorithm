import java.io.*;
import java.util.*;
public class j2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int p1 = 0;
        int p2 = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        String ans = new String();
        while(p1 < p2) {
            int diff = arr[p1] + arr[p2];
            if(diff == 0) {
                ans = Long.toString(arr[p1]) + " " + Long.toString(arr[p2]);
                break;
            }
            if(Math.abs(diff) < Math.abs(minDiff)) {
                minDiff = diff;
                ans = Long.toString(arr[p1]) + " " + Long.toString(arr[p2]);
            }
            if(diff < 0) 
                p1++;
            else if(diff > 0)
                p2--;
        }
        System.out.println(ans);
    }
}
