import java.io.*;
import java.util.*;

// 2초, 128MB
// 결국 nlogn으로 탐색해야.

public class j1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 보유 수 1~10000
        int N = Integer.parseInt(st.nextToken()); // 필요한 수 1~1000000
        int[] Lan = new int[K]; // 보유 랜선 K개 길이
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            Lan[i] = Integer.parseInt(st.nextToken()); // 인트 범위 자연수
        }
        Arrays.sort(Lan);
        
    }
    public static int lowerBound(int[] arr, int value) {
        int start = 0;
        int end = arr.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] >= value) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return end;
    }
}
