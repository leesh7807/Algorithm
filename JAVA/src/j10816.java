import java.io.*;
import java.util.*;

public class j10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1부터 50만
        st = new StringTokenizer(br.readLine());
        int[] arrN = new int[N];
        for(int i=0; i<N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken()); // -1000만부터 1000만
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 1부터 50만
        st = new StringTokenizer(br.readLine());
        int[] arrM = new int[M];
        for(int i=0; i<M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken()); // -1000만부터 1000만
        }
        Arrays.sort(arrN); // arrN 오름차순 정렬
        for(int i=0; i<M; i++) {
            int count = upperBound(arrN, arrM[i]) - lowerBound(arrN, arrM[i]); // lowerBound 찾고 1씩 움직이는 방식은 N번 움직일 위험 존재.
            sb.append(String.valueOf(count) + ' ');
        }
        System.out.println(sb);
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
    public static int upperBound(int[] arr, int value) {
        int start = 0;
        int end = arr.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] <= value) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}
