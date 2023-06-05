import java.util.*;
import java.io.*;
public class j10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> stack = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            if(func.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.add(value);
                continue;
            }
            if(func.equals("top")) {
                if(!stack.isEmpty()) {
                    bw.write(Long.toString(stack.get(stack.size()-1))+"\n");
                }
                else {
                    bw.write("-1\n");
                }
                continue;
            }
            if(func.equals("size")) {
                bw.write(Long.toString(stack.size())+"\n");
                continue;
            }
            if(func.equals("empty")) {
                if(stack.isEmpty()) {
                    bw.write("1\n");
                }
                else {
                    bw.write("0\n");
                }
            }
            if(func.equals("pop")) {
                if(!stack.isEmpty()) {
                    int len = stack.size();
                    bw.write(Long.toString(stack.get(len-1))+"\n");
                    stack.remove(len-1);
                }
                else {
                    bw.write("-1\n");
                }
            }
        }
        bw.close();
    }
}
