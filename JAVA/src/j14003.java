import java.io.*;
import java.util.*;
public class j14003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] d = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        int[] cache = new int[N];
        for(int i = 0; i < N; i++) {
            int target = arr[i];
            int lo = 0;
            int hi = N;
            while(lo + 1 < hi) {
                int mid = (lo + hi) / 2;
                if(d[mid] >= target) {
                    hi = mid;
                }
                else {
                    lo = mid;
                }
            }
            d[hi] = Math.min(d[hi], target);
            cache[i] = hi;
        }
        int LIS = 0;
        for(int i = 0; i < N; i++) {
            LIS = Math.max(LIS, cache[i]);
        }
        System.out.println(LIS);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(Integer.MAX_VALUE);
        for(int i = N - 1; i >= 0; i--) {
            if(cache[i] == LIS && arr[i] < temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
                LIS--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(temp.size() > 1) {
            sb.append(Long.toString(temp.remove(temp.size() - 1)) + " ");
        }
        System.out.println(sb.toString());
    }
    static class Pair {
        int val, pos;
        public Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}
