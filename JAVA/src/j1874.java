import java.io.*;
import java.util.*;
public class j1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int now = 0;
        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(br.readLine());
            while(now < val) {
                sb.append("+\n");
                arr.add(++now);
            }
            if(val != arr.remove(arr.size()-1)) {
                sb = new StringBuilder("NO");
                break;
            }
            sb.append("-\n");
        }
        System.out.print(sb);
    }
}
