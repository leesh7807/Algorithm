import java.util.*;
import java.io.*;
public class j15649 {
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
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                backtracking(i);
                stack.remove(stack.size() - 1);
                visited[i] = false;
            }
        }
    }
}

/* 백트래킹 문제. 순열.
 * 개념적으로는 DFS와 유사. 스택에 방문한 곳 기록해두면서 조건 만족할 떄 출력하도록.
 * 1 -> 2 -> 3 과 1 -> 3 -> 2 를 다르게 취급하는 문제이기에 방문한 곳을 어떻게 기록하고 관리할지에 대한 구현에 애를 먹었음.
 */