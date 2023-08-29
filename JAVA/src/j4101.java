import java.io.*;
import java.util.*;
public class j4101 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine()); 
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(first == 0 && second == 0) break;
            if(first > second) bw.write("Yes\n");
            else bw.write("No\n");
        }
        bw.close();
    }
}
