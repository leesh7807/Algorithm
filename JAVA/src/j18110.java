import java.io.*;
import java.util.*;
public class j18110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double d = (double)n * 0.15;
        int exceptPeople = (int)Math.round(d);
        LinkedList<Integer> arr = new LinkedList<>();
        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        arr.sort(null);
        for(int i=0; i<exceptPeople; i++) {
            arr.remove(0);
            arr.remove(arr.size()-1);
        }
        double sum = 0;
        for(Integer i : arr) {
            sum += i;
        }
        double average = sum / (n - (exceptPeople*2));
        int ans = (int)Math.round(average);
        System.out.println(ans);
    }
}
