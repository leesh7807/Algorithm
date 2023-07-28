import java.io.*;
import java.util.*;
public class j15654 {
    static ArrayList<Integer> list;
    static int N, M;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int n=0; n<N; n++) {
            list.add(Integer.parseInt(st.nextToken()));    
        }
        list.sort(null);
        boolean[] isVisited = new boolean[N];
        ArrayList<Integer> stack = new ArrayList<>();
        dfs(0, isVisited, stack);
        bw.close();
    }
    public static void dfs(int num, boolean[] isVisited, ArrayList<Integer> stack) throws Exception {
        if(stack.size() == M) {
            for(int i=0; i<stack.size(); i++) {
                bw.write(Long.toString(list.get(stack.get(i))) + " ");
            }
            bw.write("\n");
            return;
        }
        for(int n=0; n<N; n++) {
            if(isVisited[n]) continue;
            stack.add(n);
            isVisited[n] = true;
            dfs(n, isVisited, stack);
            stack.remove(stack.size()-1);
            isVisited[n] = false;
        }
    }
}
