import java.io.*;
import java.util.*;

public class j5648 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        long first = Long.parseLong(st.nextToken());
        ArrayList<Long> arr = new ArrayList<>();
        do {
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()) {
                String temp = st.nextToken();
                long num = Long.parseLong(temp);
                if(num == first) continue;
                long rev = Long.parseLong(new StringBuilder(temp).reverse().toString());
                arr.add(rev); 
            }
        } while((s=br.readLine()) != null);
        arr.sort(null);
        for(long l : arr) {
            System.out.println(l);
        }
    }
}
