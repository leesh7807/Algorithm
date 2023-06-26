import java.io.*;
import java.util.*;
public class j11866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Iterator<Integer> it = q.iterator();
        while(!q.isEmpty()) {
            for(int i=0; i<k-1; i++) {
                if(it.hasNext()) {
                    it.next();
                }
                else {
                    it = q.iterator();
                    it.next();
                }
            }
            if(it.hasNext()) {
                ans.add(it.next());
            }
            else {
                it = q.iterator();
                ans.add(it.next());
            }
            it.remove();
        }
        for(int i=0; i<n; i++) {
            if(i==0) {
                bw.write("<");
            }
            bw.write(Long.toString(ans.get(i)));
            if(i!=n-1) {
                bw.write(", ");
            }
            else {
                bw.write(">");
            }
        }
        bw.close();
    }
}
