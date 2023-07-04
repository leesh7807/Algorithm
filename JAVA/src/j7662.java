import java.util.*;
import java.io.*;
public class j7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            PriorityQueue<Integer> minpq = new PriorityQueue<>();
            PriorityQueue<Integer> delMaxpq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            PriorityQueue<Integer> delMinpq = new PriorityQueue<>();
            int k = Integer.parseInt(br.readLine());
            int size = 0;
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                String q = st.nextToken();
                int v = Integer.parseInt(st.nextToken());
                switch(q) {
                    case "I" :
                        maxpq.add(v);
                        minpq.add(v);
                        size++;
                        break;                        
                    case "D" :
                        if(size == 0) break;
                        else {
                            if(v == 1) {
                                int del = maxpq.poll();
                                while(!delMaxpq.isEmpty() && delMaxpq.peek() == del) {
                                    delMaxpq.poll();
                                    del = maxpq.poll();
                                }
                                delMinpq.add(del);
                                size--;
                            }
                            else {
                                int del = minpq.poll();
                                while(!delMinpq.isEmpty() && delMinpq.peek() == del) {
                                    delMinpq.poll();
                                    del = minpq.poll();
                                }
                                delMaxpq.add(del);
                                size--;
                            }
                        }
                        break;
                }
            }
            if(size == 0) {
                bw.write("EMPTY\n");
            }
            else {
                while(!delMaxpq.isEmpty()) {
                    if(delMaxpq.poll() == maxpq.peek()) maxpq.poll();
                }
                while(!delMinpq.isEmpty()) {
                    if(delMinpq.poll() == minpq.peek()) minpq.poll();
                }
                bw.write(Long.toString(maxpq.peek()) + " " + Long.toString(minpq.peek()) + "\n");

            }
        }
        bw.close();
    }
}

/* ArrayList로 구현하고, 삽입하는 위치를 이분탐색으로 찾는 방법을 최초 구현. => 시간 초과
 * ArrayList가 삽입, 삭제할 때 복사해서 옮기는 방식을 사용해서 느리다. 
 * LinkedList는 단순 삽입, 삭제는 빠른데 index 탐색이 O(n)이여서 특정 위치 삽입, 삭제는 느리다.
 */