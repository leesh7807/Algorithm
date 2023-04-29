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
        int[] tree = new int[N];
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree); // nlogn
        for(int H = tree[N-1]; H >= 0; H--) {
            int pos = Arrays.binarySearch(tree, H);
            if(pos > 0) {
                
            }
        }

    }
}