import java.io.*;
import java.util.*;
class j27172 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] is = new boolean[1000001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr.add(temp);
            is[temp] = true;
        }
        int[] ans = new int[1000001];
        for(int i = 0; i < N; i++) {
            int val = arr.get(i);
            for(int mult = 2; val * mult < 1000001; mult++) {
                if(is[val * mult]) {
                    ans[val]++;
                    ans[val * mult] --;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(Long.toString(ans[arr.get(i)]) + " ");
        }
        System.out.println(sb.toString());
    }
}