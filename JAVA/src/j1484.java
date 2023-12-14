import java.io.*;
public class j1484 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long G = Long.parseLong(br.readLine());
        long p1 = 1L;
        long p2 = 2L;
        while(p1 < p2) {
            long diff = p2*p2 - p1*p1;
            if(diff == G) {
                sb.append(Long.toString(p2) + "\n");
                p1++;
                p2++;
            }
            else if(diff > G) p1++;
            else if(diff < G) p2++;
        }
        if(sb.length() == 0) System.out.println(-1);
        else System.out.println(sb.toString());
    }
}
