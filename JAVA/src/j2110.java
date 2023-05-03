import java.io.*;
import java.util.*;

public class j2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());    
        int N = Integer.parseInt(st.nextToken()); // 2~200000
        int C = Integer.parseInt(st.nextToken()); // 2~N
        int[] x = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken()); // 0~10억
        }
        // 공유기 사이의 거리를 매개변수로 하는 탐색. 
        Arrays.sort(x);
        int start = 1;
        int end = x[N-1] - x[0];
        while(start <= end) {
            int mid = (start + end) / 2;
            if(canInstall(x, mid, C)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(end));
        bw.close();
    }
    public static boolean canInstall(int[] arr, int dis, int C) {
        int cnt = 1; // 첫 집 공유기
        for(int i=0; i<arr.length; i++) {
            for(int j = i+1; j<arr.length; j++) {
                if(arr[j] - arr[i] >= dis) {
                    i = j - 1;
                    cnt++;
                    break;
                }
            }
        }
        return (cnt >= C);
    }
}
