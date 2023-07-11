import java.io.*;
import java.util.*;
public class j17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            bw.write(map.get(st.nextToken()) + "\n");
        }
        bw.close();
    }
}
