import java.io.*;
import java.util.*;
public class j3733 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = new String();
        while((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int x = S / (N + 1);
            System.out.println(x);
        }
    }
}
