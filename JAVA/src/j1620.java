import java.io.*;
import java.util.*;
public class j1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        HashMap<String, String> numToEng = new HashMap<>();
        HashMap<String, String> engToNum = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String temp = br.readLine();
            numToEng.put(Long.toString(i), temp);
            engToNum.put(temp, Long.toString(i));
        }
        for(int i=0; i<M; i++) {
            String q = br.readLine();
            String ans = numToEng.get(q) != null ? numToEng.get(q) : engToNum.get(q);
            bw.write(ans + '\n');
        }
        bw.close();
    }
}
