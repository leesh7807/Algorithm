import java.io.*;
import java.util.*;

// 1초, 256MB
// 매개변수탐색 => 정답을 매겨 변수로. true/false 결정 문제로 바꾸기
class j2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수 1~1000000
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 1~2000000000
        int[] namu = new int[N];
        st = new StringTokenizer(br.readLine());
        int end = 0;
        for(int i=0; i<N; i++) {
            namu[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, namu[i]);
        }
        int start = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(cutting(namu, mid, M)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(start - 1));
        bw.close();
    }

    public static boolean cutting(int[] arr, int H, int max) {
        long sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] - H > 0) {
                sum += arr[i] - H;
            }
        }
        if(sum >= max) {
            return true;
        }
        else return false;
    }
}