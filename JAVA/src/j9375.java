import java.io.*;
import java.util.*;

public class j9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if(map.get(key) != null) {
                    map.put(key, map.get(key) + 1);
                }
                else {
                    map.put(key, 1);
                }
            }
            int ans = 1;
            for(String key : map.keySet()) {
                ans *= map.get(key) + 1;
            }
            bw.write(Long.toString(ans - 1) + '\n');
        }
        bw.close();
    }
}
