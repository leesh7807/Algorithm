import java.io.*;
import java.util.*;
public class j1208 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        makeSubsequence(0, N/2, 0, arr, left);       
        makeSubsequence(N/2, N, 0, arr, right);
        left.sort(null);
        right.sort(null);
        long ans = 0;
        for(int i = 0; i < left.size(); i++) {
            int num = left.get(i);
            int target = S - num;
            int lo = -1; 
            int hi = right.size();
            int a = lowerBound(lo, hi, target, right);
            int b = upperBound(lo, hi, target, right);
            ans += b - a;
        }   
        if(S == 0) System.out.println(ans - 1);
        else System.out.println(ans);
    }
    public static void makeSubsequence(int idx, int end, int sum, int[] arr, ArrayList<Integer> list) {
        if(idx == end) {
            list.add(sum);
            return;
        }
        makeSubsequence(idx+1, end, sum+arr[idx], arr, list);
        makeSubsequence(idx+1, end, sum, arr, list);
    }
    public static int lowerBound(int lo, int hi, int target, ArrayList<Integer> list) {
        while(lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if(list.get(mid) < target) {
                lo = mid;
            }
            else if(list.get(mid) >= target) {
                hi = mid;
            }
        }
        return hi;
    }
    public static int upperBound(int lo, int hi, int target, ArrayList<Integer> list) {
        while(lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if(list.get(mid) <= target) {
                lo = mid;
            }
            else if(list.get(mid) > target) {
                hi = mid;
            }
        }
        return hi;
    }
}
