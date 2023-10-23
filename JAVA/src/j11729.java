import java.io.*;
import java.util.*;

// 최초 LinkedList가 아닌 ArrayList를 사용.
// ArrayList.remove(0)로 마치 queue와 같이 사용 -> timeout
// ArrayList.get(idx) || LinkedList.poll() -> pass
// 객체를 용도에 맞게 사용하자.
public class j11729 {
    static LinkedList<Pair> arr = new LinkedList<>();
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 20
        hanoi(n, 1, 3);
        bw.write(Long.toString(cnt) + "\n");
        while(!arr.isEmpty()) {
            Pair temp = arr.poll();
            bw.write(Long.toString(temp.from) + " " + Long.toString(temp.to) + "\n");
        }
        bw.close();
    }    
    public static void hanoi(int n, int from, int to) {
        if(n == 1) {
            arr.add(new Pair(from, to));
            cnt++;
            return;
        }
        else {
            int mid = 6 - from - to; // 1 2 3 중에서 남는 곳.
            hanoi(n-1, from, mid);
            arr.add(new Pair(from, to));
            cnt++;
            hanoi(n-1, mid, to);
        }
    }
    static class Pair {
        int from, to;
        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
