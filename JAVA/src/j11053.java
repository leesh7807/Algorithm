import java.io.*;
import java.util.*;
public class j11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dis = new int[n+1]; // 현재 위치에서 수열의 최대 값을 저장하는 배열
        for(int i=1; i<=n; i++) {
            int maxDis = 0;
            for(int j=i-1; j>=0; j--) {
                if(arr[i] > arr[j]) {
                    maxDis = Math.max(maxDis, dis[j] + 1); // 나보다 값이 작은 것중 가장 긴 놈 + 1
                }
            }
            dis[i] = maxDis;
        }
        int ans = 0;
        for(int i=1; i<=n; i++) {
            ans = Math.max(ans, dis[i]);
        }
        bw.write(Long.toString(ans));
        bw.close();
    }
} 
