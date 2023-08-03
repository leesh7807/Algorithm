import java.io.*;
import java.util.*;
public class j15663 {
    static ArrayList<Pair> list;
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
            int node = Integer.parseInt(st.nextToken());
            boolean flag = true;
            for(int i=0; i<list.size(); i++) {
                Pair p = list.get(i);
                if(node == p.node) {
                    list.set(i, new Pair(node, p.cnt+1));
                    flag = false;
                }
            }
            if(flag) list.add(new Pair(node, 1));
        }
        list.sort((Pair a, Pair b) -> Integer.compare(a.node, b.node));
        ArrayList<Integer> stack = new ArrayList<>();
        dfs(stack);
        bw.close();
    }
    public static void dfs(ArrayList<Integer> stack) throws Exception {
        if(stack.size() == M) {
            for(int i=0; i<stack.size(); i++) {
                bw.write(Long.toString(stack.get(i)) + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<list.size(); i++) {
            Pair p = list.get(i);
            if(p.cnt > 0) {
                list.set(i, new Pair(p.node, p.cnt-1));
                stack.add(p.node);
                dfs(stack);
                list.set(i, new Pair(p.node, p.cnt));
                stack.remove(stack.size()-1);
            }
        }
    }
    static class Pair {
        int node, cnt;
        public Pair(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
}
