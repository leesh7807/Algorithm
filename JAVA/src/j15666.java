import java.io.*;
import java.util.*;
public class j15666 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> arr;
    static int N, M;
    static boolean[][] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(null);
        isVisited = new boolean[N][10000];
        dfs(0, new ArrayList<Integer>());
        bw.close();
    }
    public static void dfs(int depth, ArrayList<Integer> stack) throws Exception {
        if(depth == M) {
            for(Integer i : stack) {
                bw.write(Long.toString(i) + " ");
            }
            bw.write("\n");
            return;
        }
        ArrayList<Integer> visitArr = new ArrayList<>();
        for(Integer i : arr) {
            if(!stack.isEmpty() && stack.get(stack.size()-1) > i) continue;
            if(isVisited[depth][i]) continue; 
            isVisited[depth][i] = true;
            visitArr.add(i);
            stack.add(i);
            dfs(depth + 1, stack);
            stack.remove(stack.size()-1);
        }
        for(Integer i : visitArr) {
            isVisited[depth][i] = false;
        }
    }
}
