import java.util.*;
import java.io.*;
public class j7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            PriorityQueue<Integer> min = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                String q = st.nextToken();
                int v = Integer.parseInt(st.nextToken());
                switch(q) {
                    case "I" :
                        max.add(v);
                        min.add(v);
                        map.put(v, map.getOrDefault(v, 0) + 1);
                        break;                        
                    case "D" :
                        if(max.isEmpty() || min.isEmpty()) break;
                        if(v == 1) {
                            int del = max.peek();
                            while(!max.isEmpty() && map.get(del) == 0) {
                                del = max.poll();
                            }
                            map.put(del, map.get(del) > 0 ? map.get(del) - 1 : 0);
                        }
                        else {
                            int del = min.peek();
                            while(!min.isEmpty() && map.get(del) == 0) {
                                del = min.poll();
                            }
                            map.put(del, map.get(del) > 0 ? map.get(del) - 1 : 0);
                        }
                        break;
                }
            }
            if(max.isEmpty() || min.isEmpty()) {
                bw.write("EMPTY\n");
                continue;
            }
            int maxAns = max.peek();
            int minAns = min.peek();
            while(!max.isEmpty() && map.get(maxAns) == 0) {
                maxAns = max.poll();
            }
            while(!min.isEmpty() && map.get(minAns) == 0) {
                minAns = min.poll();
            }
            if(map.get(maxAns) == 0 || map.get(minAns) == 0) {
                bw.write("EMPTY\n");
                continue;
            }
            bw.write(Long.toString(maxAns) + " " + Long.toString(minAns) + "\n");
        }
        bw.close();
    }
}

/* ArrayList로 구현하고, 삽입하는 위치를 이분탐색(log n)으로 찾는 방법을 최초 구현. => 시간 초과
 * ArrayList가 삽입, 삭제할 때 복사해서 옮기는 방식을 사용해서 느리다. 
 * LinkedList는 양끝 삽입, 삭제는 빠른데 index 탐색이 O(n)이여서 특정 위치 삽입, 삭제는 느리다. => 값 삽입하는데 nlog n 걸린다.
 * PriorityQueue는 자바에서 배열 힙으로 구현되어 있음. 삽입과 삭제에 log n. 최소(최대) 힙에서 최대값(최소값)을 찾는 연산은 O(n)이다. 
 * 최소 힙, 최대 힙을 구현하고 HashMap에 남아 있는 원소의 개수를 기록하는 방식을 사용.
 * 
 * TreeMap 자료구조는 레드-블랙 트리로 어느정도 균형 이진 트리의 역할을 한다. => 삽입, 삭제, 최소값, 최대값 연산 모두 대략 log n에 가깝게 동작한다.
 * 이 문제는 TreeMap으로 firstKey, lastKey 불러와도 풀 수 있는 문제.
 * AVL 트리는 엄격하게 균형을 유지하여 log n으로 동작하지만, 구현이 어렵다.
 */