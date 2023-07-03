import java.io.*;
import java.util.*;
public class j2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] h = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            h[i] = Integer.parseInt(br.readLine());
            sum += h[i];
        }
        TreeSet<Integer> ans = func(sum, h);
        Iterator<Integer> iter = ans.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    public static TreeSet<Integer> func(int sum, int[] h) {
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - h[i] - h[j] == 100) {
                    TreeSet<Integer> res = new TreeSet<>();
                    for(int k=0; k<9; k++) {
                        if(k==i || k==j) continue;
                        res.add(h[k]);
                    }
                    return res;
                }
            }
        }
        return null;
    }
}
