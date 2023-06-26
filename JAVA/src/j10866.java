import java.util.*;
import java.io.*;
public class j10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        LinkedList<Integer> q = new LinkedList<>();
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch(input) {
                case "push_front" :
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if(q.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(Long.toString(q.poll()) + '\n');
                    }
                    break;
                case "pop_back" :
                    if(q.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(Long.toString(q.pollLast()) + '\n');
                    }
                    break;
                case "size" :
                    bw.write(Long.toString(q.size()) + '\n');
                    break;
                case "empty" :
                    if(q.isEmpty()) {
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                    break;
                case "front" :
                    if(q.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(Long.toString(q.getFirst()) + '\n');
                    }
                    break;
                case "back" :
                    if(q.isEmpty()) {
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(Long.toString(q.getLast()) + '\n');
                    }
                    break;
            }
        }
        bw.close();
    }
}
