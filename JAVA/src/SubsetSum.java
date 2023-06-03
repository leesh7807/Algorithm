import java.util.*;
import java.io.*;
public class SubsetSum {
    static int findingSum;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> stack = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] aisrgs) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        findingSum = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
        dfs(0, 0);
        bw.close();
    }
    public static void dfs(int depth, int sum) throws Exception {
        if(sum > findingSum) {
            return;
        }
        if(sum == findingSum) {
            for(Integer i : stack) {
                bw.write(Long.toString(list.get(i)) + ' ');
            }
            bw.write('\n');
            return;
        }
        if(depth == list.size()) {
            return;
        }
        
        dfs(depth+1, sum);
        stack.add(depth);
        dfs(depth+1, sum+list.get(depth));
        stack.remove(stack.size()-1);
    }
}       