import java.io.*;
import java.util.*;
public class j10814 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Pair> arr = new ArrayList<>();
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int tempAge = Integer.parseInt(st.nextToken());
            String tempName = st.nextToken();
            arr.add(new Pair(tempAge, tempName));
        }
        arr.sort(null);
        for(Pair p : arr) { 
            bw.write(Long.toString(p.age) + ' ' + p.name + '\n');
        }
        bw.close();
    }
    static class Pair implements Comparable<Pair> {
        int age;
        String name;
        Pair(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(age, p.age);
        }
    }
}
