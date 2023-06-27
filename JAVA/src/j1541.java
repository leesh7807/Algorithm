import java.util.*;
import java.io.*;
public class j1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        int ans = Integer.parseInt(st.nextToken());
        boolean minusFlag = false;
        while(st.hasMoreTokens()) {
            String temp = st.nextToken();
            if(temp.equals("-")) {
                minusFlag = true;
                continue;
            }
            else if(temp.equals("+")) {
                continue;
            }
            if(minusFlag) {
                ans -= Integer.parseInt(temp);
            }
            else {
                ans += Integer.parseInt(temp);
            }
        }
        System.out.println(ans);
    }
}
