import java.util.*;
import java.io.*;
public class j7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            ArrayList<Integer> dpq = new ArrayList<>();
            int k = Integer.parseInt(br.readLine());
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                String q = st.nextToken();
                int v = Integer.parseInt(st.nextToken());
                switch(q) {
                    case "I" :
                        if(dpq.isEmpty()) {
                            dpq.add(v);
                        }
                        else {
                            int first = 0;
                            int last = dpq.size();
                            while(first < last) {
                                int mid = (first + last) / 2;
                                if(dpq.get(mid) < v) {
                                    first = mid + 1;
                                }
                                else {
                                    last = mid;
                                }
                            }
                            dpq.add(first, v);
                        }
                        break;
                    case "D" :
                        if(dpq.isEmpty()) break;
                        else {
                            if(v == 1) {
                                dpq.remove(dpq.size()-1);
                            }
                            else {
                                dpq.remove(0);
                            }
                        }
                        break;
                }
            }
            if(dpq.isEmpty()) {
                bw.write("EMPTY\n");
            }
            else {
                bw.write(Long.toString(dpq.get(dpq.size()-1)) + " " + Long.toString(dpq.get(0)));
            }
        }
        bw.close();
    }
}
