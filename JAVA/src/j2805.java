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
            tree[i] = Integer.parseInt(st.nextToken()); // 나무의 최대 높이는 10억, H를 1씩 움직이며 찾으면 안됨.
        }
        Arrays.sort(tree); // nlogn
        int H = 0; // 자르는 높이
        int namu = 0; // 자른 나무 합
        int pos;
        for(pos=N-1; pos>0; pos--) { // n
            namu += (tree[pos] - tree[pos-1]) * (N - pos);
            if(namu >= M) {
                H = tree[pos-1];
                break;
            }
            else H = 0;
        }        
        int nextH = tree[pos];
        int presH = H;
        int namuChange = 0;
        while(presH < nextH) {
            int newH = (nextH + presH) / 2; // 중간 나무
            int tempNamu = namu + namuChange; // H를 옮겼을 때 변한 나무양
            if(tempNamu > M) {
                presH = newH + 1;
                namuChange = -(nextH - presH) * (N - pos); 
            }
            else if(tempNamu < M) {
                namuChange = (nextH - newH + 1) * (N - pos);
                nextH = newH - 1;
            }
            else if(tempNamu == M) {
                presH = newH;
                nextH = newH;
            }
        }
        H = presH;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(H) + '\n');
        bw.flush(); 
        bw.close();
    }

    public static int lowerBound(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] >= n) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return end;
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