import java.util.*;
import java.io.*;
public class j1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer[] ans = new Integer[N];
        for(int i=1; i<=N; i++) {
            int big = Integer.parseInt(st.nextToken());
            int index = 0;
            while(big >= 0) { // 나보다 큰사람수만큼 빈 자리 내주고 그 다음 자리를 찾아야 하므로 -1일 때
                if(ans[index] != null) {
                    index++;
                    continue;
                }
                if(ans[index] == null) {
                    big--;
                    index++;
                }
            }
            ans[index-1] = i; // index 더하기 전
        }
        for(Integer i : ans) {
            bw.write(Long.toString(i) + ' ');
        }
        bw.close();
    }
}
