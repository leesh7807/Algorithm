import java.io.*;
import java.util.*;
public class j10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        for(int k=0; k<K; k++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp > 0) {
                stack.add(temp);
            }
            else {
                stack.remove(stack.size()-1);
            }
        }
        int ans = 0;
        for(Integer i : stack) {
            ans += i;
        }
        System.out.println(ans);
    }
}
