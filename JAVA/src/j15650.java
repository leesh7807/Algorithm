import java.util.*;
import java.io.*;
public class j15650 {
    static int n;
    static int m;
    static boolean[] visited;
    static ArrayList<Integer> stack;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++) {
            stack = new ArrayList<>();
            visited = new boolean[n+1];
            backtracking(i);
        }
    }

    public static void backtracking(int v) throws Exception{
        stack.add(v);
        visited[v] = true;
        if(stack.size() == m) {
            StringBuilder sb = new StringBuilder();
            for(Integer i : stack) {
                sb.append(Long.toString(i) + ' ');
            }
            System.out.println(sb);
            return;
        }
        for(int i=v; i<=n; i++) {
            if(!visited[i]) {
                backtracking(i);
                stack.remove(stack.size() - 1);
                visited[i] = false;
            }
        }
    }
}

/* 15649 비튼 문제. 조합.
 * 1 -> 3 -> 2를 허용하지 않는다. 그 다음 행선지를 결정할 때 내 현재 위치 이후만 하도록 반복문만 수정.
 */