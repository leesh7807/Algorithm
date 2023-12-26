import java.io.*;
import java.util.*;
public class j2143 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        ArrayList<Integer> subA = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j <= N; j++) {
                subA.add(A[j] - A[i]);
            }
        }
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M + 1];
        ArrayList<Integer> subB = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M; i++) {
            for(int j = i + 1; j <= M; j++) {
                subB.add(B[j] - B[i]);
            }
        }
        subA.sort(null);
        subB.sort(null);
        long ans = 0;
        for(Integer a : subA) {
            int target = T - a;
            int lo = -1;
            int hi = subB.size();
            ans += (upperBound(target, lo, hi, subB) - lowerBound(target, lo, hi, subB));
        }
        System.out.println(ans);
    }
    static int lowerBound(int target, int lo, int hi, ArrayList<Integer> arr) {
        while(lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if(arr.get(mid) < target) {
                lo = mid;
            }
            else 
                hi = mid;
        }
        return hi;
    }
    static int upperBound(int target, int lo, int hi, ArrayList<Integer> arr) {
        while(lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if(arr.get(mid) <= target) {
                lo = mid;
            }
            else 
                hi = mid;
        }
        return hi;
    }
}
