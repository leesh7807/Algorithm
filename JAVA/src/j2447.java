import java.io.*;
import java.util.*;
public class j2447 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ans = star(n);
        System.out.println(ans);
    }
    public static String star(int n) {
        StringBuilder ret = new StringBuilder();
        if(n == 3) {
            ret.append("***\n* *\n***");
            return ret.toString();
        }
        else {
            String prevStar = star(n/3);
            for(int i=0; i<3; i++) {
                StringTokenizer st = new StringTokenizer(prevStar, "\n");
                if(i==1) {
                    String tab = new String(" ").repeat(n/3);
                    while(st.hasMoreTokens()) {
                        String prevLine = st.nextToken();
                        ret.append(prevLine + tab + prevLine + "\n");
                    }
                }
                else {
                    while(st.hasMoreTokens()) {
                        String prevLine = st.nextToken();
                        ret.append(prevLine + prevLine + prevLine + "\n");
                    }
                }
            }
            return ret.toString();
        }
    }
}
