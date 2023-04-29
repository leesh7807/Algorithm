import java.io.*;
import java.util.*;

// 나무 N개, 가져가는 나무길이 최대 20억. nlogn 안에 해결.
// 나무를 위에서부터 자른다. 자르는 높이보다 아래있으면 안짤림.
// 최대한 나무를 적게 자르고 싶다. 내가 필요한 나무 길이 넘기면서 최대한 나무 높이 자르면?
// 그래서 이게 왜 이분탐색 문제? 나무를 자르는건 특정 높이 이상의 나무를 자르는 과정.
// 특정높이 찾기 이분 탐색 logn * 특정 높이에서 나무 자른거 전부 다 더하는거 n = nlogn
class j2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken()); // 나무의 최대 높이는 10억
        }
        Arrays.sort(tree); // nlogn
        int H = 0;
        
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(H) + '\n');
        bw.flush(); 
        bw.close();
    }

    public static int upperBound(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] <= n) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}