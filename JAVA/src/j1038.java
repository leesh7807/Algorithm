import java.io.*;
import java.util.*;
public class j1038 {
    static ArrayList<Long> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(long i=0; i<10; i++) {
            arr.add(i);
            dfs(i);
        }
        arr.sort(null);
        if(n >= arr.size()) System.out.println(-1);
        else System.out.println(arr.get(n));
    }
    public static void dfs(long n) {
        for(int i=0; i<10; i++) {
            if(n%10 > i) {
                arr.add(n*10 + i);
                dfs(n*10 + i);
            }
        }
    }
}
