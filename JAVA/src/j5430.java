import java.io.*;
import java.util.*;
public class j5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> res = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), "[],", false);
            for(int i=0; i<n; i++) {
                res.add(Integer.parseInt(st.nextToken()));
            }
            boolean front = true;
            boolean error = false;
            for(int i=0; i<p.length(); i++) {
                char q = p.charAt(i);
                switch(q) {
                    case 'R' :
                        if(front) front = false;
                        else front = true;
                        break;
                    case 'D' :
                        if(res.isEmpty()) {
                            error = true;
                        }
                        else {
                            if(front) res.removeFirst();
                            else res.removeLast();
                        }
                        break;
                }
            }
            if(error) {
                bw.write("error\n");
            }
            else {
                if(res.isEmpty()) {
                    bw.write("[]\n");
                }
                else {
                    if(front) bw.write(res.toString().replace(" ", "") + "\n");
                    else {
                        Collections.reverse(res);
                        bw.write(res.toString().replace(" ", "") + "\n");
                    }
                }
            }
        }
        bw.close();
    }
}