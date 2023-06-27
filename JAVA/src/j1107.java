import java.io.*;
import java.util.*;
public class j1107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int ichan = Integer.parseInt(N);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        boolean[] error = new boolean[10];
        if(M > 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                error[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int ans = Math.abs(ichan - 100);
        for(int i=0; i<1000000; i++) {
            boolean stopFlag = false;
            char[] tempI = Long.toString(i).toCharArray();
            for(int c=0; c<tempI.length; c++) {
                if(error[tempI[c] - 48]) {
                    stopFlag = true;
                    break;
                }
            }
            if(stopFlag) continue;
            int nearAns = Math.abs(ichan - i) + tempI.length;
            ans = Math.min(ans, nearAns);
        }
        System.out.println(ans);
    }
}
